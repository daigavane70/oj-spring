package com.sprint.kafka.producer;

import com.sprint.repository.entity.Submission;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class SubmissionProducer {
    @Autowired
    private KafkaTemplate<String, Submission> kafkaTemplate;

    @Value("${kafka.topic.submission}")
    String topicName;

    public void sendMessage(Submission submission) {
        log.info("[SubmissionProducer] message: {}", submission);
        this.kafkaTemplate.send(topicName, submission);
    }

    public void sendBatchMessage(List<Submission> batch){
        batch.forEach(submission -> {
            log.info("[SubmissionProducer] message: {}", submission);
            this.kafkaTemplate.send(topicName, submission);
        });
    }
}
