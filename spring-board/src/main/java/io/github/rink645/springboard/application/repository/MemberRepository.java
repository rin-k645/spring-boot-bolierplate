package io.github.rink645.springboard.application.repository;

import io.github.rink645.springboard.domain.model.Member;

public interface MemberRepository {
    Member save(Member member);
    Member findById(Long memberId);
}
