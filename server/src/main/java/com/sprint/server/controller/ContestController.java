package com.sprint.server.controller;


import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.function.EntityResponse;

@RestController
public class ContestController {

    @GetMapping("/contests")
    public HttpEntity getAllContests(){
        return new HttpEntity("All Contest");
    }
}
