package com.web.multi.domain.enums;

import com.web.multi.global.error.exception.NotSupportedCodeException;
import lombok.Getter;

import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;
public enum EMemberRole {
    ROLE_ADMIN("ADMIN"), ROLE_MEMBER("MEMBER");

    @Getter
    private final String code;

    EMemberRole(String code) {
        this.code = code;
    }

    private static final Map<String, EMemberRole> map = Stream.of(EMemberRole.values()).collect(Collectors.toMap(EMemberRole::getCode, Function.identity()));

    public static EMemberRole from(String code) {
        return Optional
                .ofNullable(map.get(code))
                .orElseThrow(() -> new NotSupportedCodeException("{" + code + "} is not supported code."));
    }
}
