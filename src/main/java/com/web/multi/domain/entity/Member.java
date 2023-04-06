package com.web.multi.domain.entity;

import com.web.multi.domain.enums.EMemberRole;
import com.web.multi.domain.enums.EMemberStatus;
import com.web.multi.domain.enums.converter.EMemberRoleConverter;
import com.web.multi.domain.enums.converter.EMemberStatusConverter;
import com.web.multi.domain.repository.IMemberRepository;
import com.web.multi.global.domain.BaseTimeEntity;
import com.web.multi.global.error.exception.ConflictException;
import com.web.multi.global.util.EncryptionUtil;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

@EqualsAndHashCode(of = "loginId")
@DynamicInsert @DynamicUpdate
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
@Getter
@Table(name = "member")
@Entity
public class Member extends BaseTimeEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "login_id")
    private String loginId;

    @Column(name = "password")
    private String password;

    @Convert(converter = EMemberRoleConverter.class)
    @Column(name = "role")
    private EMemberRole role;

    @Convert(converter = EMemberStatusConverter.class)
    @Column(name = "status")
    private EMemberStatus status;

    @Embedded
    private MemberAuthorities authorities = new MemberAuthorities();
    public static Member signUpMember(String loginId, String password, IMemberRepository repository) {
        Member member = new Member();
        member.loginId = loginId;
        member.checkLoginIdDuplication(repository);
        member.setHashedPassword(password);
        member.role = EMemberRole.ROLE_MEMBER;
        member.status = EMemberStatus.ACTIVE;
        repository.save(member);
        return member;
    }

    public static Member signUpAdmin(String loginId, String password, IMemberRepository repository) {
        Member admin = new Member();
        admin.loginId = loginId;
        admin.checkLoginIdDuplication(repository);
        admin.setHashedPassword(password);
        admin.role = EMemberRole.ROLE_ADMIN;
        admin.status = EMemberStatus.ACTIVE;
        admin.authorities = MemberAuthorities.getAdminAuthorities(admin);
        repository.save(admin);
        return admin;
    }

    public void setHashedPassword(String password) {
        this.password = EncryptionUtil.encodeBcrypt(password);
    }

    public void checkLoginIdDuplication(IMemberRepository repository) {
        if (repository.existsByLoginId(this.loginId)) throw new ConflictException(ConflictException.CauseCode.DUPLICATE_LOGIN_ID);
    }

}
