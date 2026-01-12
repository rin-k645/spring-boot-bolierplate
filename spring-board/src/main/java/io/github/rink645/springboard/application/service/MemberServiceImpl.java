package io.github.rink645.springboard.application.service;

import io.github.rink645.springboard.application.repository.MemberRepository;
import io.github.rink645.springboard.domain.exception.MemberNotFoundException;
import io.github.rink645.springboard.domain.model.Member;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@Transactional
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {
    private final MemberRepository memberRepository;

    @Override
    public Long register(String name, String email) {
        Member member = Member.create(name, email);
        return memberRepository.save(member).getId();
    }

    @Override
    public void update(Long memberId, String name) {
        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new MemberNotFoundException(memberId));
        member.update(name);
        memberRepository.save(member);
    }

    @Override
    public void withdraw(Long memberId) {
        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new MemberNotFoundException(memberId));
        member.withdraw();
        memberRepository.save(member);
    }

    @Override
    public Member find(Long memberId) {
        return memberRepository.findById(memberId)
                .orElseThrow(() -> new MemberNotFoundException(memberId));

    }
}
