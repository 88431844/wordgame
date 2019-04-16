package controller.back;

import dto.WordInfoDto;
import entity.WordInfo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import service.WordService;

@Controller
@RequestMapping("/backWord")
public class BackWordController {

    @Autowired
    private WordService wordService;

    @RequestMapping("/add")
    public ModelAndView add(WordInfo wordInfo){
        ModelAndView modelAndView = new ModelAndView();
        if (0 == wordService.haveWord(wordInfo)){
            wordService.addWord(wordInfo);
            modelAndView.addObject("message","添加成功");
        }
        else {
            modelAndView.addObject("message","添加失败，汉字名称重复");
        }
        return modelAndView;
    }

    @RequestMapping("/del")
    public ModelAndView del(@RequestParam("id")int id){
        ModelAndView modelAndView = new ModelAndView();
        wordService.delWord(id);
        modelAndView.addObject("message","删除成功");
        return modelAndView;
    }

    @RequestMapping("/update")
    public ModelAndView update(WordInfo wordInfo){
        ModelAndView modelAndView = new ModelAndView();
        wordService.updateWord(wordInfo);
        modelAndView.addObject("message","更新成功");
        return modelAndView;
    }

    @RequestMapping("/list")
    public ModelAndView list(){
        ModelAndView modelAndView = new ModelAndView();
       return listWord(modelAndView);
    }
    private ModelAndView listWord(ModelAndView modelAndView){
        modelAndView.setViewName("back/word/listWord");
        List<WordInfoDto> wordInfoDtoList = wordService.listWord();
        modelAndView.addObject("wordInfoDtoList",wordInfoDtoList);
        return modelAndView;
    }
}
