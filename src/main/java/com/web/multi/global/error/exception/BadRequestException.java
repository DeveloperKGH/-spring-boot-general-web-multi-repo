package com.web.multi.global.error.exception;

import com.web.multi.global.error.ErrorResult;
import lombok.Getter;

import java.util.List;

@Getter
public class BadRequestException extends BaseException {

	public String code;

	public String message;
	private final List<ErrorResult> errorResults;

	public BadRequestException(List<ErrorResult> errorResults) {
		this.code = "4000000";
		this.message = "Bad Request";
		this.errorResults = errorResults;
	}

}