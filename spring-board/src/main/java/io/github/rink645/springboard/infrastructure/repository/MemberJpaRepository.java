package io.github.rink645.springboard.infrastructure.repository;

import io.github.rink645.springboard.infrastructure.entitiy.MemberJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberJpaRepository extends JpaRepository<MemberJpaEntity, Long> {
}
