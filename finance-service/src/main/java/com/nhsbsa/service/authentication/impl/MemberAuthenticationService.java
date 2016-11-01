package com.nhsbsa.service.authentication.impl;

import com.nhsbsa.model.Member;
import com.nhsbsa.security.LoginRequest;
import com.nhsbsa.service.MemberService;
import com.nhsbsa.service.authentication.AuthenticationService;
import com.nhsbsa.service.authentication.AuthorizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * Created by jeffreya on 22/08/2016.
 */
@Service
@Transactional
public class MemberAuthenticationService implements AuthenticationService<Member> {


    private final MemberService memberService;
    private final AuthorizationService authorizationService;

    @Autowired
    public MemberAuthenticationService(final MemberService memberService, final AuthorizationService authorizationService) {
        this.memberService = memberService;
        this.authorizationService = authorizationService;
    }

    @Override
    public Member authenticateUser(final LoginRequest loginRequest) {
        return memberService.loadByUUID(loginRequest.getUuid());
    }

    @Override
    public Member resetPassword(final LoginRequest loginRequest) {
        final Member member = memberService.loadByEmail(loginRequest.getUsername());
        if (member == null) {
            throw new IllegalArgumentException("email address doesn't exist: " + loginRequest.getUsername());
        }
        return memberService.saveMemberDetails(member);
    }
}
