package com.web.multi.domain.enums.converter;

import com.web.multi.domain.enums.EMemberStatus;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.util.Optional;

@Converter
public class EMemberStatusConverter implements AttributeConverter<EMemberStatus, String> {
    @Override
    public String convertToDatabaseColumn(EMemberStatus attribute) {
        return Optional.ofNullable(attribute).isPresent() ? attribute.name() : null;
    }

    @Override
    public EMemberStatus convertToEntityAttribute(String dbData) {
        return Optional.ofNullable(dbData).isPresent() ? EMemberStatus.valueOf(dbData) : null;
    }
}
