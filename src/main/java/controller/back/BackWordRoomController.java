package controller.back;

import dto.WordRoomDto;
import entity.WordRoom;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import service.WordService;

@Controller
@RequestMapping("/backWordRoom")
public class BackWordRoomController {

    @Autowired
    private WordService wordService;

    @RequestMapping("/toAdd")
    public ModelAndView toAdd(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("back/wordroom/addWordRoom");
        return modelAndView;
    }
    @RequestMapping("/add")
    public ModelAndView add(String wordRoomName){
        ModelAndView modelAndView = new ModelAndView();
        if (0 == wordService.haveWordRoom(wordRoomName)){
            wordService.addWordRoom(wordRoomName);
            modelAndView.addObject("message","添加成功");
        }
        else {
            modelAndView.addObject("message","添加失败，字库名字重复");
        }
        return listWordRoom(modelAndView);
    }

    @RequestMapping("/del")
    public ModelAndView del(@RequestParam("id") int id){
        ModelAndView modelAndView = new ModelAndView();
        if (0 == wordService.wordRoomHaveWord(id)){
            wordService.delWordRoom(id);
            modelAndView.addObject("message","删除成功");
        }
        else {
            modelAndView.addObject("message","删除失败，字库下面有汉字");
        }

        return listWordRoom(modelAndView);
    }

    @RequestMapping("/toEdit")
    public ModelAndView toEdit(@RequestParam("id") int id){
        ModelAndView modelAndView = new ModelAndView();
        WordRoom wordRoom = wordService.getByWordRoomId(id);
        modelAndView.addObject("wordRoom",wordRoom);
        modelAndView.setViewName("back/wordroom/editWordRoom");
        return modelAndView;
    }
    @RequestMapping("/edit")
    public ModelAndView edit(WordRoomDto wordRoomDto){
        ModelAndView modelAndView = new ModelAndView();
        if (wordRoomDto.getOldName().equals(wordRoomDto.getWordRoomName())){
            modelAndView.addObject("message","更新成功");
        }
        else if (0 == wordService.haveWordRoom(wordRoomDto.getWordRoomName())){
            wordService.editWordRoom(wordRoomDto);
            modelAndView.addObject("message","更新成功");
        }
        else {
            modelAndView.addObject("message","更新失败，字库名称重复");
        }
        return listWordRoom(modelAndView);
    }

    @RequestMapping("/list")
    public ModelAndView list(){
        ModelAndView modelAndView = new ModelAndView();
        return listWordRoom(modelAndView);
    }
    private ModelAndView listWordRoom(ModelAndView modelAndView){
        List<WordRoom> wordRoomList = wordService.list();
        modelAndView.addObject("wordRoomList",wordRoomList);
        modelAndView.setViewName("back/wordroom/listWordRoom");
        return modelAndView;
    }
}
