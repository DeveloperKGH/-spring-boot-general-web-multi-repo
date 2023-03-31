package com.web.multi.domain.enums.converter;

import com.web.multi.domain.enums.MemberStatus;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.util.Optional;

@Converter
public class MemberStatusConverter implements AttributeConverter<MemberStatus, String> {
    @Override
    public String convertToDatabaseColumn(MemberStatus attribute) {
        return Optional.ofNullable(attribute).isPresent() ? attribute.name() : null;
    }

    @Override
    public MemberStatus convertToEntityAttribute(String dbData) {
        return Optional.ofNullable(dbData).isPresent() ? MemberStatus.valueOf(dbData) : null;
    }
}
