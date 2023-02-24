package com.web.multi.global.common.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class BaseResponse<T> {
	private String code;
	private String message;
	private LocalDateTime timestamp;
	private T data;

	public static <T> BaseResponse<T> successResponse(T data) {
		BaseResponse<T> response = new BaseResponse<>();
		response.setCode("200");
		response.setMessage("SUCCESS");
		response.setTimestamp(LocalDateTime.now());
		response.setData(data);
		return response;
	}

	public static <T> BaseResponse<T> errorResponse(String code, String message, T data) {
		BaseResponse<T> response = new BaseResponse<>();
		response.setCode(code);
		response.setMessage(message);
		response.setTimestamp(LocalDateTime.now());
		response.setData(data);
		return response;
	}
}