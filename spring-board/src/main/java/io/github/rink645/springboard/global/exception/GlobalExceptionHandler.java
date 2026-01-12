package io.github.rink645.springboard.global.exception;

import io.github.rink645.springboard.domain.exception.MemberNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 비즈니스 예외(Domain, Application)
     */
    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<ApiErrorResponse> handleCustomException(BusinessException e, HttpServletRequest request) {
        ErrorCode code = e.getErrorCode();
        log.warn(
                "[BusinessException] code={}, message={}, uri={}",
                code.getCode(),
                code.getMessage(),
                request.getRequestURI()
        );
        return ResponseEntity
                .status(code.getStatus())
                .body(ApiErrorResponse.from(code));
    }

    /**
     * 회원을 찾을 수 없는 경우
     */
    @ExceptionHandler(MemberNotFoundException.class)
    public ResponseEntity<ApiErrorResponse> handleMemberNotFound(MemberNotFoundException e) {
        ErrorCode code = e.getErrorCode();
        log.warn("[MemberNotFound] memberId={}", e.getMemberId());
        return ResponseEntity
                .status(code.getStatus())
                .body(ApiErrorResponse.from(code));
    }

    /**
     * 예상치 못한 모든 예외
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiErrorResponse> handleUnexpectedException(Exception e, HttpServletRequest request) {
        log.error(
                "[UnexpectedException] uri={}, message={}",
                request.getRequestURI(),
                e.getMessage(),
                e
        );

        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(ApiErrorResponse.from(ErrorCode.INTERNAL_ERROR));
    }
}

