package com.sprint.common.request;

import lombok.Data;
//import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.lang.reflect.Array;
import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
public class ContestRequest {
    public String name;
    public LocalDateTime startTime;
    public LocalDateTime endTime;
    public Integer totalQuestions;
    public List<String> description;
}
