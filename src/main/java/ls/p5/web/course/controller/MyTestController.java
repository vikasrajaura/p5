package ls.p5.web.course.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MyTestController {

    @GetMapping("/courses")
    public String courses(){
        return "courses";
    }

    @GetMapping("/")
    public String main(Model model){
        model.addAttribute("msg", "Hi welcome to Thymeleaf");
        return "index";
    }

    @GetMapping("/viewChapterTopics")
    public String viewChapterTopics(Model model){
        model.addAttribute("msg", "Hi welcome to Thymeleaf");
        return "course/view_chapterTopics";
    }
}