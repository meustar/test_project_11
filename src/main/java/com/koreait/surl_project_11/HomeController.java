package com.koreait.surl_project_11;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {

    @GetMapping("a")
    @ResponseBody
    public String hi1(
            String age,
            String id
    ) {
        return "안녕, %s번, %s 살이야.".formatted(id, age);
    }

    @GetMapping("b")
    @ResponseBody
    public String plus(
            @RequestParam("a") String num1Str,
            String b
    ) {
        int num1 = Integer.parseInt(num1Str);
        int num2 = Integer.parseInt(b);
        System.out.println("a : " + num1);
        System.out.println("b : " + num2);
        return "a + b = %d".formatted(num1 + num2);
    }
}
