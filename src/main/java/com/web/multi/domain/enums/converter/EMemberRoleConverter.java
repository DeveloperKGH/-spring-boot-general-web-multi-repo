package com.web.multi.domain.enums.converter;

import com.web.multi.domain.enums.EMemberRole;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.util.Optional;

@Converter
public class EMemberRoleConverter implements AttributeConverter<EMemberRole, String> {
    @Override
    public String convertToDatabaseColumn(EMemberRole attribute) {
        return Optional.ofNullable(attribute).isPresent() ? attribute.getCode() : null;
    }

    @Override
    public EMemberRole convertToEntityAttribute(String dbData) {
        return Optional.ofNullable(dbData).isPresent() ? EMemberRole.from(dbData) : null;
    }
}
