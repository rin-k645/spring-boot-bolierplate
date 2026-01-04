package io.github.rink645.springboard.presentation.controller;

import io.github.rink645.springboard.application.service.MemberService;
import io.github.rink645.springboard.presentation.dto.request.MemberCreateRequest;
import io.github.rink645.springboard.presentation.dto.request.MemberUpdateRequest;
import io.github.rink645.springboard.presentation.dto.response.MemberResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/members")
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;

    @PostMapping
    public Long register(@RequestBody MemberCreateRequest request) {
        return memberService.register(request.name(), request.email());
    }

    @PutMapping("/{id}")
    public void update(@PathVariable Long id,
                       @RequestBody MemberUpdateRequest request) {
        memberService.update(id, request.name());
    }

    @DeleteMapping("/{id}")
    public void withdraw(@PathVariable Long id) {
        memberService.withdraw(id);
    }

    @GetMapping("/{id}")
    public MemberResponse get(@PathVariable Long id) {
        return MemberResponse.from(memberService.find(id));
    }
}
