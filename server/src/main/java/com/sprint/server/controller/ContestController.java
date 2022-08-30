package com.sprint.server.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class ContestController {

    @GetMapping("/contest")
    public HttpEntity getAllContests(){
        return new HttpEntity("All Contest");
    }

    @GetMapping("/contest/{id}")
    public HttpEntity getContestById(){
        return new HttpEntity("Get Contest By ID");
    }

}
