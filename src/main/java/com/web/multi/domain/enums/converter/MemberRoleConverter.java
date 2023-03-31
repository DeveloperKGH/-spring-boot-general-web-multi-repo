package com.web.multi.domain.enums.converter;

import com.web.multi.domain.enums.MemberRole;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.util.Optional;

@Converter
public class MemberRoleConverter implements AttributeConverter<MemberRole, String> {
    @Override
    public String convertToDatabaseColumn(MemberRole attribute) {
        return Optional.ofNullable(attribute).isPresent() ? attribute.getCode() : null;
    }

    @Override
    public MemberRole convertToEntityAttribute(String dbData) {
        return Optional.ofNullable(dbData).isPresent() ? MemberRole.from(dbData) : null;
    }
}
