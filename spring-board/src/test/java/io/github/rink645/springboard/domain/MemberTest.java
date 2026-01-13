package io.github.rink645.springboard.domain;

import io.github.rink645.springboard.domain.exception.AlreadyWithdrawnMemberException;
import io.github.rink645.springboard.domain.model.Member;
import io.github.rink645.springboard.domain.model.MemberStatus;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class MemberTest {
    @Test
    @DisplayName("회원 생성 성공")
    void create_member_success() {
        // when
        Member member = Member.create("test", "test@test.com");

        // then
        assertThat(member.getId()).isNull();
        assertThat(member.getName()).isEqualTo("test");
        assertThat(member.getEmail()).isEqualTo("test@test.com");
        assertThat(member.getStatus()).isEqualTo(MemberStatus.ACTIVE);
    }

    @Test
    @DisplayName("회원 이름 수정")
    void update_member_name() {
        // given
        Member member = Member.reconstitute(
                1L,
                "test",
                "test@test.com",
                MemberStatus.ACTIVE
        );

        // when
        member.update("test2");

        // then
        assertThat(member.getName()).isEqualTo("test2");
    }

    @Test
    @DisplayName("회원 탈퇴 성공")
    void withdraw_member_success() {
        // given
        Member member = Member.reconstitute(
                1L,
                "test",
                "test@test.com",
                MemberStatus.ACTIVE
        );

        // when
        member.withdraw();

        // then
        assertThat(member.getStatus()).isEqualTo(MemberStatus.WITHDRAWN);
    }

    @Test
    @DisplayName("이미 탈퇴한 회원의 탈퇴 실패")
    void withdraw_member_fail() {
        // given
        Member member = Member.reconstitute(
                1L,
                "test",
                "test@test.com",
                MemberStatus.WITHDRAWN
        );

        // when & then
        assertThatThrownBy(member::withdraw).isInstanceOf(AlreadyWithdrawnMemberException.class);
    }

}
