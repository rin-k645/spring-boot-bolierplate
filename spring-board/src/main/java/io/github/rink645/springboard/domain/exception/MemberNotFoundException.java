package io.github.rink645.springboard.domain.exception;

import io.github.rink645.springboard.global.exception.BusinessException;
import io.github.rink645.springboard.global.exception.ErrorCode;
import lombok.Getter;

@Getter
public class MemberNotFoundException extends BusinessException {
    private final Long memberId;

    public MemberNotFoundException(Long memberId) {
        super(ErrorCode.MEMBER_NOT_FOUND);
        this.memberId = memberId;
    }
}
