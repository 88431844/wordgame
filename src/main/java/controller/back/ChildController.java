package controller.back;

import dto.ChildInfoDto;
import entity.ChildInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import service.ChildService;

import java.util.List;

@Controller
@RequestMapping("/child")
public class ChildController {

    @Autowired
    private ChildService childService;

    @RequestMapping("/toAdd")
    public ModelAndView toAdd(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("back/child/addChild");
        return modelAndView;
    }

    @RequestMapping("/add")
    public ModelAndView add(String childName){
        ModelAndView modelAndView = new ModelAndView();
        if (0 == childService.haveChild(childName)){
            childService.add(childName);
            modelAndView.addObject("message","添加成功");
        }
        else {
            modelAndView.addObject("message","添加失败，孩子名称重复");
        }
        return listChild(modelAndView);
    }

    @RequestMapping("/del")
    public ModelAndView del(@RequestParam("id")int id){
        ModelAndView modelAndView = new ModelAndView();
        childService.del(id);
        modelAndView.addObject("message","删除成功");
        return listChild(modelAndView);
    }

    @RequestMapping("/toEdit")
    public ModelAndView toEdit(@RequestParam("id")int id){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("back/child/editChild");
        ChildInfo childInfo = childService.getChildById(id);
        modelAndView.addObject("childInfo",childInfo);
        return modelAndView;
    }
    @RequestMapping("/edit")
    public ModelAndView edit(ChildInfoDto childInfoDto){
        ModelAndView modelAndView = new ModelAndView();
        if (childInfoDto.getChildName().equals(childInfoDto.getOldName())){
            modelAndView.addObject("message","更新成功");
        }
        else if (0 == childService.haveChild(childInfoDto.getChildName())){
            childService.edit(childInfoDto);
            modelAndView.addObject("message","更新成功");
        }
        else {
            modelAndView.addObject("message","更新失败，孩子名称重复");
        }
        return listChild(modelAndView);
    }

    @RequestMapping("/list")
    public ModelAndView list(){
        ModelAndView modelAndView = new ModelAndView();
        return listChild(modelAndView);
    }
    private ModelAndView listChild(ModelAndView modelAndView){
        List<ChildInfo> childInfoList = childService.list();
        modelAndView.addObject("childInfoList",childInfoList);
        modelAndView.setViewName("back/child/listChild");
        return modelAndView;
    }
}
