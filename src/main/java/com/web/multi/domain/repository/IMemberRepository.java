package com.web.multi.domain.repository;

import com.web.multi.domain.entity.Member;

import java.util.Optional;

public interface IMemberRepository {
    Member save(Member member);
    boolean existsByLoginId(String loginId);

    Optional<Member> findByLoginId(String loginId);
}
