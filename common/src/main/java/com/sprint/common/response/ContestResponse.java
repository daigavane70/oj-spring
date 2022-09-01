package com.sprint.common.response;

import com.sprint.repository.entity.Contest;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ContestResponse extends Contest {
    Status status;
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public class Status {
        String description;
        double time;
    }
}
