package controller.back;

import dto.WordInfoDto;
import entity.WordInfo;

import java.util.List;

import entity.WordRoom;
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

    @RequestMapping("/toAdd")
    public ModelAndView toAdd() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("back/word/addWord");
        List<WordRoom> wordRoomList = wordService.list();
        if (wordRoomList.size() == 0){
            WordRoom wordRoom = new WordRoom();
            wordRoom.setId(0);
            wordRoom.setWordroomname("请先添加字库");
            wordRoomList.add(wordRoom);
        }
        modelAndView.addObject("wordRoomList",wordRoomList);
        return modelAndView;
    }

    @RequestMapping("/add")
    public ModelAndView add(WordInfo wordInfo) {
        ModelAndView modelAndView = new ModelAndView();
        if (0 == wordService.haveWord(wordInfo)) {
            wordService.addWord(wordInfo);
            modelAndView.addObject("message", "添加成功");
        } else {
            modelAndView.addObject("message", "添加失败，汉字名称重复");
        }
        return listWord(modelAndView);
    }

    @RequestMapping("/del")
    public ModelAndView del(@RequestParam("id") int id) {
        ModelAndView modelAndView = new ModelAndView();
        wordService.delWord(id);
        modelAndView.addObject("message", "删除成功");
        return listWord(modelAndView);
    }

    @RequestMapping("/toEdit")
    public ModelAndView toEdit(@RequestParam("id") int id) {
        ModelAndView modelAndView = new ModelAndView();
        WordInfoDto wordInfoDto = wordService.getWordById(id);
        modelAndView.addObject("wordInfoDto",wordInfoDto);
        modelAndView.setViewName("back/word/editWord");
        return listWord(modelAndView);
    }

    @RequestMapping("/edit")
    public ModelAndView edit(WordInfo wordInfo) {
        ModelAndView modelAndView = new ModelAndView();
        wordService.editWord(wordInfo);
        modelAndView.addObject("message", "更新成功");
        return listWord(modelAndView);
    }

    @RequestMapping("/list")
    public ModelAndView list() {
        ModelAndView modelAndView = new ModelAndView();
        return listWord(modelAndView);
    }

    private ModelAndView listWord(ModelAndView modelAndView) {
        modelAndView.setViewName("back/word/listWord");
        List<WordInfoDto> wordInfoDtoList = wordService.listWord();
        modelAndView.addObject("wordInfoDtoList", wordInfoDtoList);
        return modelAndView;
    }
}
