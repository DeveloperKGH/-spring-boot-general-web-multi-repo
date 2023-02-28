package com.web.multi.global.error.exception;

import com.web.multi.global.error.ErrorResult;
import lombok.Getter;

import java.util.List;

public class BadRequestException extends BaseException {

	@Getter
	private final List<ErrorResult> errorResults;

	public BadRequestException(List<ErrorResult> errorResults) {
		this.errorResults = errorResults;
	}

}