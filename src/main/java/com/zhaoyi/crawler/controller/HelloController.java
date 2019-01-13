package com.zhaoyi.crawler.controller;

import com.zhaoyi.crawler.service.AqyIndexHandlerService;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileNotFoundException;
import java.io.IOException;

@RestController
public class HelloController {

    @Autowired
    private AqyIndexHandlerService aqyIndexHandlerService;


    @GetMapping("/channel")
    public String chanel(){
        try {
            aqyIndexHandlerService.getChannel();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "get channel info success";
    }

    @GetMapping("movie")
    public String movie(){
        aqyIndexHandlerService.getMovieInfoInChannel();
        return "success";
    }
    @GetMapping("/")
    public String index(){
        aqyIndexHandlerService.getAllMovie();
        return "success";
    }
}
