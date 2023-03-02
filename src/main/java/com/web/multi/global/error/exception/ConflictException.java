package com.web.multi.global.error.exception;

import lombok.Getter;

public class ConflictException extends BaseException {

    @Getter
    public enum CauseCode {
        DUPLICATE_LOGIN_ID("4090001", "아이디가 중복됩니다.");

        private String code;
        private String message;

        CauseCode(String code, String message) {
            this.code = code;
            this.message = message;
        }

    }

    public ConflictException(CauseCode cause) {
        super(cause.getCode(), cause.getMessage());
    }

}