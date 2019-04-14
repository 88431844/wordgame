package controller.front;

import dao.ChildInfoMapper;
import entity.ChildInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private ChildInfoMapper childInfoMapper;

    @RequestMapping("/childLogin")
    public ModelAndView childLogin(String childName, HttpSession session){
        ModelAndView modelAndView = new ModelAndView();
        ChildInfo childInfo = childInfoMapper.getChildByName(childName);
        session.setAttribute("childName",childName);
        session.setAttribute("childId",childInfo.getId());
        modelAndView.setViewName("front/word/wordList");
        return modelAndView;
    }
}
