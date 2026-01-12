package io.github.rink645.springboard.domain.exception;

import io.github.rink645.springboard.global.exception.ErrorCode;

public class AlreadyWithdrawnMemberException extends MemberDomainException {
    public AlreadyWithdrawnMemberException() {
        super(ErrorCode.MEMBER_ALREADY_WITHDRAWN);
    }
}
