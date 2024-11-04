package com.koreait.surl_project_11;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {

    @GetMapping("a")
    @ResponseBody
    public String hi1() {
        return "hi1";
    }

    @GetMapping("b")
    @ResponseBody
    public String hi2() {
        return "hi2";
    }
}
