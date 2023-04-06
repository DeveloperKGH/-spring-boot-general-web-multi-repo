package com.web.multi.application.service;

import com.web.multi.application.dto.CreateAdminServiceDto;
import com.web.multi.domain.entity.Member;
import com.web.multi.domain.repository.IMemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class AdminService {

    private final IMemberRepository memberJpaRepository;

    @Transactional
    public Long createAdmin(CreateAdminServiceDto dto) {
        return Member.signUpAdmin(dto.getLoginId(), dto.getPassword(), memberJpaRepository).getId();
    }

}
