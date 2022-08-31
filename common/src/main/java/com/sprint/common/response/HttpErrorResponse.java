package com.sprint.common.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class HttpErrorResponse {
    int code;
    String message;
}
