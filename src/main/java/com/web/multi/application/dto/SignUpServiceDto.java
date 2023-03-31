package com.web.multi.application.dto;


import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class SignUpServiceDto {
    private String loginId;
    private String password;

}
