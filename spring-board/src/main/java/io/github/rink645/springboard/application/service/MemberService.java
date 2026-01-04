package io.github.rink645.springboard.application.service;

import io.github.rink645.springboard.domain.model.Member;

public interface MemberService {
    Long register(String name, String email);
    void update(Long memberId, String name);
    void withdraw(Long memberId);
    Member find(Long memberId);
}
