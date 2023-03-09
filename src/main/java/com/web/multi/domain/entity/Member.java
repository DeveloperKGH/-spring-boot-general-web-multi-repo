package com.web.multi.domain.entity;

import com.web.multi.domain.enums.MemberRole;
import com.web.multi.domain.enums.converter.MemberRoleConverter;
import com.web.multi.global.domain.BaseTimeEntity;
import com.web.multi.global.util.EncryptionUtil;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.DynamicUpdate;

@EqualsAndHashCode(of = "loginId")
@DynamicUpdate
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

    @Builder
    public Member(String loginId, String password, MemberRole role) {
        this.loginId = loginId;
        this.password = EncryptionUtil.encodeBcrypt(password);
        this.role = role;
    }

}
