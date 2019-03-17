package controller;

import entity.Muser;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.ModelAndView;
import service.TestService;
import com.jacob.activeX.ActiveXComponent;
import com.jacob.com.Dispatch;
import com.jacob.com.Variant;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;


@Controller
public class TestController {

    @RequestMapping("/tts")
    public ModelAndView tts(@ModelAttribute Muser user) {

        System.out.println("-----TestController tts");
        ActiveXComponent sap = new ActiveXComponent("Sapi.SpVoice");

        Dispatch sapo = sap.getObject();
        try {

            // 音量 0-100
            sap.setProperty("Volume", new Variant(100));
            // 语音朗读速度 -10 到 +10
            sap.setProperty("Rate", new Variant(1));


            System.out.println("请输入要朗读的内容：");
            Scanner scan = new Scanner(System.in);
//            String str=scan.next();

            String str = user.getUsername();
            // 执行朗读
            Dispatch.call(sapo, "Speak", new Variant(str));

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sapo.safeRelease();
            sap.safeRelease();
        }
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("front/movie/movieWall");
        return modelAndView;
    }

    @RequestMapping("/asr")
    public ModelAndView asr(HttpServletRequest request) throws  Exception {
        System.out.println("-------- test asr");
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("front/movie/movieWall");

       String message = request.getRequestURL().toString();
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
                    String path="D:\\code\\wordgame\\target\\wordgame-1.0-SNAPSHOT\\uploadFile\\test.wav";
                    //上传
                    file.transferTo(new File(path));
                }

            }

        }


        modelAndView.addObject("message",message);

        return modelAndView;
    }
}
