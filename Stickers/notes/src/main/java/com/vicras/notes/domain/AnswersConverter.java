package com.vicras.notes.domain;

import javax.persistence.AttributeConverter;
import java.util.List;

/**
 * @author viktar hraskou
 */
public class AnswersConverter implements AttributeConverter<List<String>, String> {

    @Override
    public String convertToDatabaseColumn(List<String> attribute) {
        return String.join("~", attribute);
    }

    @Override
    public List<String> convertToEntityAttribute(String dbData) {
        return List.of(dbData.split("~"));
    }
}
