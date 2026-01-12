package io.github.rink645.springboard.infrastructure.mapper;

import io.github.rink645.springboard.domain.model.Member;
import io.github.rink645.springboard.infrastructure.entitiy.MemberJpaEntity;
import org.springframework.stereotype.Component;

@Component
public class MemberEntityMapper {
    public Member toDomain(MemberJpaEntity entity) {
        return Member.reconstitute(
                entity.getId(),
                entity.getName(),
                entity.getEmail(),
                entity.getStatus()
        );
    }

    public MemberJpaEntity toEntity(Member member) {
        return MemberJpaEntity.builder()
                .id(member.getId())
                .name(member.getName())
                .email(member.getEmail())
                .status(member.getStatus())
                .build();
    }
}
