package com.web.multi.application.service;

import com.web.multi.domain.entity.CustomUserDetail;
import com.web.multi.domain.entity.Member;
import com.web.multi.domain.repository.IMemberRepository;
import com.web.multi.global.error.exception.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CustomUserDetailService implements UserDetailsService {
    private final IMemberRepository memberJpaRepository;

    @Override
    public UserDetails loadUserByUsername(String loginId) throws NotFoundException {
        Member member = memberJpaRepository.findByLoginId(loginId)
                .orElseThrow(() -> new NotFoundException(NotFoundException.CauseCode.NOT_FOUND_MEMBER));
        return new CustomUserDetail(member);
    }
}
