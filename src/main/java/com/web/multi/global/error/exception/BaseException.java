package com.web.multi.global.error.exception;

import lombok.*;


@NoArgsConstructor @AllArgsConstructor
@Getter
@ToString
@EqualsAndHashCode(callSuper = false)
public class BaseException extends RuntimeException {

    public String code;

    public String message;

}
