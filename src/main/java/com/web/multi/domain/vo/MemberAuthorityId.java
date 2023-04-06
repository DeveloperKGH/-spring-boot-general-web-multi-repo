package com.web.multi.domain.vo;

import com.web.multi.domain.enums.EMemberAuthority;
import com.web.multi.domain.enums.converter.EMemberAuthorityConverter;
import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;

import java.io.Serializable;

@Builder
@AllArgsConstructor @NoArgsConstructor
@Embeddable
public class MemberAuthorityId implements Serializable {
    @Column(name = "member_id")
    private Long memberId;
    @Convert(converter = EMemberAuthorityConverter.class)
    @Column(name = "authority")
    private EMemberAuthority authority;

    @ColumnDefault("false")
    @Column(name = "is_deleted")
    private boolean isDeleted;
}
