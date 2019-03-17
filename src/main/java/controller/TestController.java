package controller;

import entity.Muser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import service.TestService;
import com.jacob.activeX.ActiveXComponent;
import com.jacob.com.Dispatch;
import com.jacob.com.Variant;
import java.util.Scanner;


@Controller
public class TestController {

    @RequestMapping("/tts")
    public ModelAndView tts(@ModelAttribute Muser user){

        System.out.println("-----TestController tts");
        ActiveXComponent sap = new ActiveXComponent("Sapi.SpVoice");

        Dispatch sapo = sap.getObject();
        try {

            // 音量 0-100
            sap.setProperty("Volume", new Variant(100));
            // 语音朗读速度 -10 到 +10
            sap.setProperty("Rate", new Variant(1));


            System.out.println("请输入要朗读的内容：");
            Scanner scan=new Scanner(System.in);
//            String str=scan.next();

            String str= user.getUsername();
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
}
