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
    public HttpErrorResponse error;

    public HttpApiResponse(T data){
        this.success = true;
        this.data = data;
        this.error = null;
    }
}
