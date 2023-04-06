package com.web.multi.interfaces.controller;

import com.web.multi.application.service.AdminService;
import com.web.multi.global.common.controller.BaseController;
import com.web.multi.global.common.dto.BaseResponse;
import com.web.multi.interfaces.dto.CreateAdminRequest;
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
public class AdminController extends BaseController {

    private final AdminService adminService;

    /**
     * 어드민 생성 API
     *
     * @param request 어드민 생성 요청 request
     * @param bindingResult request 검증 오류정보 저장
     * @return BaseResponse<Long> 가입된 어드민 고유 ID
     */
    @PostMapping("/admins/admin")
    public BaseResponse<Long> createAdmin(@RequestBody @Valid CreateAdminRequest request, BindingResult bindingResult) {
        checkBindings(bindingResult);
        return BaseResponse.successResponse(adminService.createAdmin(request.toServiceDto()));
    }

}

