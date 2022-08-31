package com.sprint.common.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HttpApiResponse <T> {
    public boolean success;
    public T data;
    public Error error;

    public HttpApiResponse(T data){
        this.success = false;
        this.data = data;
        this.error = null;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public class Error{
        int code;
        String message;
    }
}
