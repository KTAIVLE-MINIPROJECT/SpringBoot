package com.aivle1_3.BookApi.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

    @RequestMapping(value = { "/", "/book/**" })
    public String forward() {
        return "forward:/index.html";
    }

}
