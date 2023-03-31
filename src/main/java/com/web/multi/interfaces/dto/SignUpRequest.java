package com.web.multi.interfaces.dto;

import com.web.multi.application.dto.SignUpServiceDto;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@AllArgsConstructor @NoArgsConstructor
@Builder
@Setter @Getter
@ToString
@EqualsAndHashCode
public class SignUpRequest {

    @NotBlank()
    private String loginId;

    @NotBlank()
    private String password;

    public SignUpServiceDto toServiceDto() {
        return SignUpServiceDto.builder()
                .loginId(loginId)
                .password(password)
                .build();
    }

}
