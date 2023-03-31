package com.web.multi.application.service;

import com.web.multi.application.dto.SignUpServiceDto;
import com.web.multi.domain.entity.Member;
import com.web.multi.domain.repository.IMemberRepository;
import com.web.multi.global.error.exception.ConflictException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class SignService {

    private final IMemberRepository memberJpaRepository;

    @Transactional
    public Long signUp(SignUpServiceDto dto) {
        if (memberJpaRepository.existsByLoginId(dto.getLoginId())) {
            throw new ConflictException(ConflictException.CauseCode.DUPLICATE_LOGIN_ID);
        }

        return Member.signUpMember(dto.getLoginId(), dto.getPassword(), memberJpaRepository).getId();
    }

}
