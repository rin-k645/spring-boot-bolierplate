package io.github.rink645.springboard.domain.model;

import io.github.rink645.springboard.domain.exception.AlreadyWithdrawnMemberException;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder(access = AccessLevel.PRIVATE)
public class Member {
    private final Long id;
    private String name;
    private String email;
    private MemberStatus status;

    public static Member create(String name, String email) {
        return Member.builder()
                .name(name)
                .email(email)
                .status(MemberStatus.ACTIVE)
                .build();
    }

    public static Member reconstitute(Long id, String name, String email, MemberStatus status) {
        return Member.builder()
                .id(id)
                .name(name)
                .email(email)
                .status(status)
                .build();
    }

    public void update(String name) {
        this.name = name;
    }

    public void withdraw() {
        if (this.status == MemberStatus.WITHDRAWN) {
            throw new AlreadyWithdrawnMemberException();
        }
        this.status = MemberStatus.WITHDRAWN;
    }
}
