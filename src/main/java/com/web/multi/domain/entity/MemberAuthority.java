package com.web.multi.domain.entity;

import com.web.multi.domain.enums.EMemberAuthority;
import com.web.multi.domain.vo.MemberAuthorityId;
import com.web.multi.global.domain.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

@EqualsAndHashCode(exclude = {"member"})
@DynamicInsert @DynamicUpdate
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@ToString(exclude = {"member"})
@Getter
@Table(name = "member_authority")
@Entity
public class MemberAuthority extends BaseTimeEntity {
    @EmbeddedId
    private MemberAuthorityId id;

    @ManyToOne()
    @JoinColumn(name = "member_id")
    @MapsId("memberId")
    private Member member;

    @Builder
    public MemberAuthority(Member member, EMemberAuthority authority) {
        this.setMember(member);
        this.id = MemberAuthorityId.builder()
                .memberId(member.getId())
                .authority(authority)
                .isDeleted(false)
                .build();
    }

    public void setMember(Member member) {
        if (this.member != null) {
            this.member.getAuthorities().getAuthorities().remove(this);
        }

        this.member = member;
        this.member.getAuthorities().getAuthorities().add(this);
    }
}