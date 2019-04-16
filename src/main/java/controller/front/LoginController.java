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
        if (null != childInfo && childInfo.getId() > 0){
            session.setAttribute("childName",childName);
            session.setAttribute("childId",childInfo.getId());
            modelAndView.addObject("message","登录成功");
        }
        else {
            modelAndView.addObject("message","登录失败，请检查儿童名称是否存在");
        }
        modelAndView.setViewName("front/word/wordList");
        return modelAndView;
    }
}
