package com.koolss.www.matting;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication
public class MattingApplication {

    public static void main(String[] args) {
        SpringApplication.run(MattingApplication.class, args);
    }


    @RequestMapping("/")
    public String index() {
        return "index";
    }
}
