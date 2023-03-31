package com.web.multi.domain.entity;

import com.web.multi.domain.enums.MemberRole;
import com.web.multi.domain.enums.MemberStatus;
import com.web.multi.domain.enums.converter.MemberRoleConverter;
import com.web.multi.domain.enums.converter.MemberStatusConverter;
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

    @Convert(converter = MemberRoleConverter.class)
    @Column(name = "role")
    private MemberRole role;

    @Convert(converter = MemberStatusConverter.class)
    @Column(name = "status")
    private MemberStatus status;
    public static Member signUpMember(String loginId, String password, IMemberRepository repository) {
        Member member = new Member();
        member.loginId = loginId;
        member.checkLoginIdDuplication(repository);
        member.setHashedPassword(password);
        member.role = MemberRole.ROLE_MEMBER;
        member.status = MemberStatus.ACTIVE;
        repository.save(member);
        return member;
    }

    public void setHashedPassword(String password) {
        this.password = EncryptionUtil.encodeBcrypt(password);
    }

    public void checkLoginIdDuplication(IMemberRepository repository) {
        if (repository.existsByLoginId(this.loginId)) throw new ConflictException(ConflictException.CauseCode.DUPLICATE_LOGIN_ID);
    }

}
