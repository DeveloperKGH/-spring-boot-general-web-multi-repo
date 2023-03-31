package com.web.multi.interfaces.controller;

import com.web.multi.application.service.SignService;
import com.web.multi.global.common.controller.BaseController;
import com.web.multi.global.common.dto.BaseResponse;
import com.web.multi.interfaces.dto.SignUpRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequiredArgsConstructor
@RestController
public class SignController extends BaseController {

    private final SignService signService;

    /**
     * 회원가입 API
     *
     * @param request 회원가입 요청 request
     * @param bindingResult request 검증 오류정보 저장
     * @return BaseResponse<Long> 가입회원 고유 ID
     */
    @PostMapping("/sign-up")
    public BaseResponse<Long> signup(@RequestBody @Valid SignUpRequest request, BindingResult bindingResult) {
        checkBindings(bindingResult);
        return BaseResponse.successResponse(signService.signUp(request.toServiceDto()));
    }

}

