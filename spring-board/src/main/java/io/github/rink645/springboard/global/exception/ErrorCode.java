package io.github.rink645.springboard.global.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode {

    MEMBER_NOT_FOUND(404, "MEMBER_NOT_FOUND", "회원을 찾을 수 없습니다."),
    MEMBER_ALREADY_WITHDRAWN(400, "MEMBER_ALREADY_WITHDRAWN", "이미 탈퇴한 회원입니다."),
    INVALID_REQUEST(400, "INVALID_REQUEST", "잘못된 요청입니다."),
    INTERNAL_ERROR(500, "INTERNAL_ERROR", "서버 오류");

    private final int status;
    private final String code;
    private final String message;
}

