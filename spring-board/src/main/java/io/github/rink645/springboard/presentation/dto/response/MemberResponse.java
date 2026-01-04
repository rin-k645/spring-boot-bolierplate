package io.github.rink645.springboard.presentation.dto.response;

import io.github.rink645.springboard.domain.model.Member;
import io.github.rink645.springboard.domain.model.MemberStatus;

public record MemberResponse(Long id, String name, String email, MemberStatus status) {

    public static MemberResponse from(Member member) {
        return new MemberResponse(
                member.getId(),
                member.getName(),
                member.getEmail(),
                member.getStatus()
        );
    }
}

