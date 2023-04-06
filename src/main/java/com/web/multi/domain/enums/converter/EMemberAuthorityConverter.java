package com.web.multi.domain.enums.converter;

import com.web.multi.domain.enums.EMemberAuthority;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.util.Optional;

@Converter
public class EMemberAuthorityConverter implements AttributeConverter<EMemberAuthority, String> {
    @Override
    public String convertToDatabaseColumn(EMemberAuthority attribute) {
        return Optional.ofNullable(attribute).isPresent() ? attribute.name() : null;
    }

    @Override
    public EMemberAuthority convertToEntityAttribute(String dbData) {
        return Optional.ofNullable(dbData).isPresent() ? EMemberAuthority.valueOf(dbData) : null;
    }
}
