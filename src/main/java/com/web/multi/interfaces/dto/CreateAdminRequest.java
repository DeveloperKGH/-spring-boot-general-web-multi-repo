package com.web.multi.interfaces.dto;

import com.web.multi.application.dto.CreateAdminServiceDto;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@AllArgsConstructor @NoArgsConstructor
@Builder
@Setter @Getter
@ToString
@EqualsAndHashCode
public class CreateAdminRequest {

    @NotBlank()
    private String loginId;

    @NotBlank()
    private String password;

    public CreateAdminServiceDto toServiceDto() {
        return CreateAdminServiceDto.builder()
                .loginId(loginId)
                .password(password)
                .build();
    }

}
