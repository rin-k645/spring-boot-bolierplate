package io.github.rink645.springboard.application.repository;

import io.github.rink645.springboard.domain.model.Member;

import java.util.Optional;

public interface MemberRepository {
    Member save(Member member);
    Optional<Member> findById(Long memberId);
}
