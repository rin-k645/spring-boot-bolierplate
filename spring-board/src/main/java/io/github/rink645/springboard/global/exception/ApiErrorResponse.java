package io.github.rink645.springboard.global.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ApiErrorResponse {
    private String code;
    private String message;

    public static ApiErrorResponse from(ErrorCode errorCode) {
        return new ApiErrorResponse(
                errorCode.getCode(),
                errorCode.getMessage()
        );
    }
}

