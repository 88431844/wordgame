package controller.front;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.iflytek.msp.cpdb.lfasr.client.LfasrClientImp;
import com.iflytek.msp.cpdb.lfasr.exception.LfasrException;
import com.iflytek.msp.cpdb.lfasr.model.LfasrType;
import com.iflytek.msp.cpdb.lfasr.model.Message;
import com.iflytek.msp.cpdb.lfasr.model.ProgressStatus;
import com.jacob.activeX.ActiveXComponent;
import com.jacob.com.Dispatch;
import com.jacob.com.Variant;
import dto.ChildWordDto;
import entity.WordInfo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.UUID;
import service.WordService;

@Controller
@RequestMapping("/word")
public class WordController {

    @Autowired
    private WordService wordService;

   //tts setting start
    // 音量 0-100
    private static int volume = 100;
    // 语音朗读速度 -10 到 +10
    private static int rate = 1;
    //tts setting end

    //asr setting start
    // 等待时长（秒）
    private static int sleepSecond = 2;
    private static final LfasrType type = LfasrType.LFASR_STANDARD_RECORDED_AUDIO;
    //asr setting end

    @RequestMapping("/tts")
    public ModelAndView tts(@RequestParam("wordName") String wordName,@RequestParam("childId") Integer childId) {
      System.out.println(System.getProperty("java.library.path"));
        System.out.println("-----wordController tts");
        ActiveXComponent sap = new ActiveXComponent("Sapi.SpVoice");

        Dispatch sapo = sap.getObject();
        try {
            // 音量 0-100
            sap.setProperty("Volume", new Variant(volume));
            // 语音朗读速度 -10 到 +10
            sap.setProperty("Rate", new Variant(rate));
            // 执行朗读
            Dispatch.call(sapo, "Speak", new Variant(wordName));

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sapo.safeRelease();
            sap.safeRelease();
        }
        ModelAndView modelAndView = new ModelAndView();
        return initChildWordList(modelAndView,childId);
    }

    /**
     * 1.根据传入的wordid查询对应word名称
     * 2.根据上传的音频文件，通过讯飞识别出对应音频文字
     * 3.比较讯飞识别文字和查询出来的word名称是否一致
     * 4.如果一致则该儿童对该汉字正确次数加一，否则错误次数加一，并返回前端正确，错误结果
     */
    @RequestMapping("/asr")
    public ModelAndView asr(HttpServletRequest request, HttpSession session,
        @RequestParam("wordid") int wordid,@RequestParam("wordname") String wordname) {

        System.out.println("-----wordController asr");
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("front/word/wordList");
        Integer childId = (int)session.getAttribute("childId");


        String path = "";
        //将当前上下文初始化给  CommonsMutipartResolver （多部分解析器）
        CommonsMultipartResolver multipartResolver=new CommonsMultipartResolver(
                request.getSession().getServletContext());
        //检查form中是否有enctype="multipart/form-data"
        if(multipartResolver.isMultipart(request))
        {
            //将request变成多部分request
            MultipartHttpServletRequest multiRequest=(MultipartHttpServletRequest)request;
            //获取multiRequest 中所有的文件名
            Iterator iter=multiRequest.getFileNames();

            while(iter.hasNext())
            {
                //一次遍历所有文件
                MultipartFile file=multiRequest.getFile(iter.next().toString());
                if(file!=null)
                {
                    String localTempDir = "D:\\\\code\\\\wordgame\\\\target\\\\wordgame-1.0-SNAPSHOT\\\\uploadFile\\\\";
                    String fileName = UUID.randomUUID() + ".wav";
                    path = localTempDir + fileName;
                    File tempFile = null;
                    try {
                        tempFile = new File(localTempDir + fileName);
                        if (!tempFile.getParentFile().exists()) {
                            tempFile.getParentFile().mkdirs();
                        }
                        if (!tempFile.exists()) {
                            tempFile.createNewFile();
                        }

                        file.transferTo(tempFile);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        String asrBackMessage = processASRJson(audioToMessage(path));
        System.out.println("asr asrBackMessage : " + asrBackMessage);
        System.out.println("asr wordname : " + wordname);
        if (asrBackMessage.equals(wordname)){
            wordService.updateChildTrain(childId,wordid,true);
            session.setAttribute("asr_session","恭喜你，回答正确！");
        }else {
            wordService.updateChildTrain(childId,wordid,false);
            session.setAttribute("asr_session","回答错误，加油加油！");
        }

//      System.out.println("wordid : " + wordid);
//      System.out.println("childId : " + childId);
//      System.out.println("wordname : " + wordname);
//      System.out.println("----- asr session set done !!!");

        return modelAndView;
    }

    @RequestMapping("/list")
    public ModelAndView list(Integer childId,String message) {
        System.out.println("-----wordController list");
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("message",message);
        return initChildWordList(modelAndView,childId);
    }

    private String audioToMessage(String local_file){
        String ret = "";
        long  s = System.currentTimeMillis();
        // 初始化LFASRClient实例
        LfasrClientImp lc = null;
        try {
            lc = LfasrClientImp.initLfasrClient();
        } catch (LfasrException e) {
            // 初始化异常，解析异常描述信息
            Message initMsg = JSON.parseObject(e.getMessage(), Message.class);
            System.out.println("ecode=" + initMsg.getErr_no());
            System.out.println("failed=" + initMsg.getFailed());
        }

        // 获取上传任务ID
        String task_id = "";
        HashMap<String, String> params = new HashMap<String, String>();
        params.put("has_participle", "true");
        //合并后标准版开启电话版功能
        //params.put("has_seperate", "true");
        try {
            // 上传音频文件
            Message uploadMsg = lc.lfasrUpload(local_file, type, params);

            // 判断返回值
            int ok = uploadMsg.getOk();
            if (ok == 0) {
                // 创建任务成功
                task_id = uploadMsg.getData();
                System.out.println("task_id=" + task_id);
            } else {
                // 创建任务失败-服务端异常
                System.out.println("ecode=" + uploadMsg.getErr_no());
                System.out.println("failed=" + uploadMsg.getFailed());
            }
        } catch (LfasrException e) {
           e.printStackTrace();
        }

        // 循环等待音频处理结果
        while (true) {
            try {
                // 等待20s在获取任务进度
                Thread.sleep(sleepSecond * 1000);
                System.out.println("waiting ...");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                // 获取处理进度
                Message progressMsg = lc.lfasrGetProgress(task_id);

                // 如果返回状态不等于0，则任务失败
                if (progressMsg.getOk() != 0) {
                    System.out.println("task was fail. task_id:" + task_id);
                    System.out.println("ecode=" + progressMsg.getErr_no());
                    System.out.println("failed=" + progressMsg.getFailed());


                } else {
                    ProgressStatus progressStatus = JSON.parseObject(progressMsg.getData(), ProgressStatus.class);
                    if (progressStatus.getStatus() == 9) {
                        // 处理完成
                        System.out.println("task was completed. task_id:" + task_id);
                        break;
                    } else {
                        // 未处理完成
                        System.out.println("task is incomplete. task_id:" + task_id + ", status:" + progressStatus.getDesc());
                        continue;
                    }
                }
            } catch (LfasrException e) {
              e.printStackTrace();
            }
        }

        // 获取任务结果
        try {
            Message resultMsg = lc.lfasrGetResult(task_id);
            // 如果返回状态等于0，则获取任务结果成功
            if (resultMsg.getOk() == 0) {
                // 打印转写结果
                ret = resultMsg.getData();
                System.out.println("---- ASR resultMsg : "+ret);
            } else {
                // 获取任务结果失败
                System.out.println("ecode=" + resultMsg.getErr_no());
                System.out.println("failed=" + resultMsg.getFailed());
            }
        } catch (LfasrException e) {
           e.printStackTrace();
        }

        long e = System.currentTimeMillis();
        System.out.println(
                "-------- cost :"+(e-s)/1000 + " s");
        return ret;
    }
    @RequestMapping("/toMessage")
    public ModelAndView toMessage(HttpServletRequest request,HttpSession session){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("front/word/message");
        String requestMessage = (String)request.getAttribute("requestMessage");
        if (null != requestMessage){
            request.setAttribute("requestMessage",requestMessage);
        }

        String sessionMessage = (String)session.getAttribute("sessionMessage");
        if (null != sessionMessage){
            session.setAttribute("sessionMessage",sessionMessage);
        }
        return modelAndView;
    }
    private String processASRJson(String json){
        JSONArray allArray = JSONArray.parseArray(json);
        String wordResultList = String.valueOf(allArray.get(0));
        JSONObject jsonObject = JSONObject.parseObject(wordResultList);
        JSONArray wordList = JSONArray.parseArray(String.valueOf(jsonObject.get("wordsResultList")));
        String wordStr = String.valueOf(wordList.get(0));
        JSONObject wordJson = JSONObject.parseObject(wordStr);
        return String.valueOf(wordJson.get("wordsName"));
    }
    public ModelAndView initChildWordList(ModelAndView modelAndView,Integer childId){
        modelAndView.setViewName("front/word/wordList");
        List<ChildWordDto> childWordDtoList = wordService.listChildWord(childId);
        modelAndView.addObject("childWordDtoList",childWordDtoList);
        return modelAndView;
    }
    @RequestMapping("/removeSession")
  public ModelAndView removeSession(HttpSession session){
      ModelAndView modelAndView = new ModelAndView();
      session.setAttribute("asr_session","");
      return initChildWordList(modelAndView,null);
    }
}
