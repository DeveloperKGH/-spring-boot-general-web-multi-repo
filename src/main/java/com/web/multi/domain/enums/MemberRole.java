package com.web.multi.domain.enums;

import com.web.multi.global.error.exception.NotSupportedCodeException;
import lombok.Getter;

import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;
public enum MemberRole {
    ROLE_ADMIN("ADMIN"), ROLE_MEMBER("MEMBER");

    @Getter
    private final String code;

    MemberRole(String code) {
        this.code = code;
    }

    private static final Map<String, MemberRole> map = Stream.of(MemberRole.values()).collect(Collectors.toMap(MemberRole::getCode, Function.identity()));

    public static MemberRole from(String code) {
        return Optional
                .ofNullable(map.get(code))
                .orElseThrow(() -> new NotSupportedCodeException("{" + code + "} is not supported code."));
    }
}
