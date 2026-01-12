package io.github.rink645.springboard.infrastructure.repository;

import io.github.rink645.springboard.domain.model.Member;
import io.github.rink645.springboard.application.repository.MemberRepository;
import io.github.rink645.springboard.infrastructure.entitiy.MemberJpaEntity;
import io.github.rink645.springboard.infrastructure.mapper.MemberEntityMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class MemberRepositoryImpl implements MemberRepository {

    private final MemberJpaRepository jpaRepository;
    private final MemberEntityMapper mapper;

    @Override
    public Member save(Member member) {
        MemberJpaEntity saved =
                jpaRepository.save(mapper.toEntity(member));
        return mapper.toDomain(saved);
    }

    @Override
    public Optional<Member> findById(Long memberId) {
        return jpaRepository.findById(memberId)
                .map(mapper::toDomain);
    }
}
