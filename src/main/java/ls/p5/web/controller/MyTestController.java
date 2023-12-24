package ls.p5.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MyTestController {

    @GetMapping("/")
    public String test(){
        return "index";
    }



}