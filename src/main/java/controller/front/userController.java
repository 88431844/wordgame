package controller.front;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class userController {

    @RequestMapping("/toRegisterUser")
    public String toRegisterUser(){
        return "front/user/registerUser";
    }

    @RequestMapping("/registerUser")
    public ModelAndView registerUser(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("front/movie/movieWall");
        modelAndView.addObject("message","注册成功");
        return modelAndView;
    }

    @RequestMapping("/toLogin")
    public String toLogin(){
        return "front/user/userLogin";
    }

    @RequestMapping("/userLogin")
    public ModelAndView userLogin(HttpSession session){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("front/movie/movieWall");
        modelAndView.addObject("message","登录成功");
        session.setAttribute("nickName","最佳男主角");
//        modelAndView.addObject("nickName","最佳男主角");
        return modelAndView;
    }
    @RequestMapping("/userLogout")
    public ModelAndView userLogout(HttpSession session){
        ModelAndView modelAndView = new ModelAndView();
        session.setAttribute("nickName",null);
        modelAndView.setViewName("front/movie/movieWall");
        modelAndView.addObject("message","登出成功");
        return modelAndView;

    }



}
