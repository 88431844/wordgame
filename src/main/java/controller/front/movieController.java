package controller.front;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import service.TestService;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/movie")
public class movieController {

    @Autowired
    private TestService testService;

    @RequestMapping("/wall")
    public ModelAndView wall(){
        ModelAndView modelAndView = new ModelAndView();
        System.out.println("----- movie wall loading .....");
        modelAndView.setViewName("front/movie/movieWall");

        return modelAndView;
    }

    @RequestMapping("/detail")
    public ModelAndView detail(){
        ModelAndView modelAndView = new ModelAndView();
        System.out.println("----- movie detail  .....");
        modelAndView.setViewName("front/movie/movieDetail");

        return modelAndView;
    }

    @RequestMapping("/seat")
    public ModelAndView test(){
        System.out.println("-------- movie seat !");
        ModelAndView modelAndView = new ModelAndView();

        Map<String,Object> movie = new HashMap<>();
        movie.put("movieName","塞尔达");
        movie.put("movieDate","2019年03月06日");
        movie.put("moviePrice","88");

        modelAndView.setViewName("front/movie/selectSeat");

        modelAndView.addObject("movie",movie);

        testService.testMysql();

        return modelAndView;
    }
}
