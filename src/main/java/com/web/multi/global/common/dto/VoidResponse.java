package com.web.multi.global.common.dto;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class VoidResponse {
    private final static VoidResponse instance;

    static {
        instance = new VoidResponse();
    }

    public static VoidResponse getInstance() {
        return instance;
    }
}
