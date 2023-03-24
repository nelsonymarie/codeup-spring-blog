package com.codeup.codeupspringblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MathController {

    @GetMapping("/add/3/and/4")
    @ResponseBody
    public String add() {
        return String.valueOf(3 + 4);
    }

    @GetMapping("/subtract/3/from/10")
    @ResponseBody
    public String subtract() {
        return String.valueOf(10 - 3);
    }

    @GetMapping("/multiply/4/and/5")
    @ResponseBody
    public String multiply() {
        return String.valueOf(4 * 5);
    }

    @GetMapping("/divide/6/by/3")
    @ResponseBody
    public String divide() {
        return String.valueOf(6 / 3);
    }

    // the original code for handling variables has been removed
}
