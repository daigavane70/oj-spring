package com.sprint.common.request;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ContestRequest {
    public String name;
    public String startTime;
    public String endTime;
    public Integer totalQuestions;
    public List<String> description;
}
