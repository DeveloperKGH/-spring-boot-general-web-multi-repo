package com.web.multi.domain.entity;

import com.web.multi.domain.enums.EMemberAuthority;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Embeddable;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

import static jakarta.persistence.FetchType.EAGER;

@EqualsAndHashCode(exclude = {"authorities"})
@ToString(exclude = {"authorities"})
@Getter
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@Embeddable
public class MemberAuthorities {
    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL, orphanRemoval = true, fetch = EAGER)
    private List<MemberAuthority> authorities = new ArrayList<>();

    public void add(MemberAuthority authority) {
        this.authorities.add(authority);
    }

    public static MemberAuthorities getAdminAuthorities(Member admin) {
        MemberAuthorities adminAuthorities = new MemberAuthorities();
        adminAuthorities.add(MemberAuthority.builder().member(admin).authority(EMemberAuthority.BAN_MEMBER).build());
        adminAuthorities.add(MemberAuthority.builder().member(admin).authority(EMemberAuthority.VIEW_MEMBER_INFO).build());
        return adminAuthorities;
    }
}