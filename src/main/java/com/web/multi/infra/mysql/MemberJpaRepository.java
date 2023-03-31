package com.web.multi.infra.mysql;


import com.web.multi.domain.entity.Member;
import com.web.multi.domain.repository.IMemberRepository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberJpaRepository extends IMemberRepository, JpaRepository<Member, Long> {
    boolean existsByLoginId(String loginId);

}
