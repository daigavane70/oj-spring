package com.sprint.server.controller;

import com.sprint.common.response.HttpApiResponse;
import com.sprint.kafka.producer.SubmissionProducer;
import com.sprint.repository.entity.Submission;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class SubmissionController {

    @Autowired
    SubmissionProducer submissionProducer;

    @PostMapping(value = "/submission", produces = MediaType.APPLICATION_JSON_VALUE)
    public HttpApiResponse submit(@RequestBody Submission submission) {
        submissionProducer.sendMessage(submission);
        return new HttpApiResponse(submission);
    }

}
