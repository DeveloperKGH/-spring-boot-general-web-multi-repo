package com.web.multi.global.common.controller;

import com.web.multi.global.common.dto.BaseResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class HealthCheckController {
    @GetMapping(value="/health-check")
    public BaseResponse<String> checkHealth() {
        String result = "Server Is Running...";
        return BaseResponse.successResponse(result);
    }

}