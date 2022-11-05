package com.sprint.kafka.consumer;

import com.sprint.repository.entity.Submission;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class SubmissionListener {

    @KafkaListener(topics = "${kafka.topic.submission}", groupId = "${kafka.groupid.submission}")
    public void consume(Submission submission) {
        log.info("consuming submission: {}", submission);
    }
}
