package com.web.multi.global.error;

import com.web.multi.global.common.dto.BaseResponse;
import com.web.multi.global.common.dto.VoidResponse;
import com.web.multi.global.error.exception.BadRequestException;
import com.web.multi.global.error.exception.BaseException;
import com.web.multi.global.error.exception.ConflictException;
import com.web.multi.global.error.exception.NotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Collections;
import java.util.List;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(BadRequestException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public BaseResponse<List<ErrorResult>> handle400Exception(HttpServletRequest request, BadRequestException exception) {
		printError(request, exception);
		return BaseResponse.errorResponse(exception.getCode(), exception.getMessage(), exception.getErrorResults());
	}

	@ExceptionHandler(NotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public BaseResponse<VoidResponse> handle404Exception(HttpServletRequest request, NotFoundException exception) {
		printError(request, exception);
		return BaseResponse.errorResponse(exception.getCode(), exception.getMessage(), VoidResponse.getInstance());
	}

	@ExceptionHandler(ConflictException.class)
	@ResponseStatus(HttpStatus.CONFLICT)
	public BaseResponse<VoidResponse> handle409Exception(HttpServletRequest request, ConflictException exception) {
		printError(request, exception);
		return BaseResponse.errorResponse(exception.getCode(), exception.getMessage(), VoidResponse.getInstance());
	}

	@ExceptionHandler(Exception.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public BaseResponse<List> handle500Exception(Exception exception) {
		log.error("===============Print 500 Error===============");
		log.error("[ExceptionHandle] trace : {}", exception);
		log.error("=========================================");
		return BaseResponse.errorResponse("5000000000", exception.getMessage(), Collections.EMPTY_LIST);
	}

	private void printError(HttpServletRequest request, BaseException exception) {
		log.error("===============PrintError===============");
		log.error("[ExceptionHandle] request-url: {}", request.getRequestURL());
		log.error("[ExceptionHandle] error: {}", exception.getCode());
		log.error("[ExceptionHandle] message: {}", exception.getMessage());
		log.error("=========================================");

	}

}