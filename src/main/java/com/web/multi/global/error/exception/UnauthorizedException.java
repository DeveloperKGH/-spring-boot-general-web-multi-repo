package com.web.multi.global.error.exception;

import lombok.Getter;

public class UnauthorizedException extends BaseException {

    @Getter
    public enum CauseCode {
        INVALID_TOKEN("4010001", "유효하지 않은 토큰입니다.");

        private String code;
        private String message;

        CauseCode(String code, String message) {
            this.code = code;
            this.message = message;
        }

    }

    public UnauthorizedException(CauseCode cause) {
        super(cause.getCode(), cause.getMessage());
    }

}