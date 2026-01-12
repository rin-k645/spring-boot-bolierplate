package io.github.rink645.springboard.domain.exception;

import io.github.rink645.springboard.global.exception.BusinessException;
import io.github.rink645.springboard.global.exception.ErrorCode;

public abstract class MemberDomainException extends BusinessException {
    protected MemberDomainException(ErrorCode errorCode) {
        super(errorCode);
    }
}
