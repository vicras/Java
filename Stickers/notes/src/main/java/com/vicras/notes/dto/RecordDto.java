package com.vicras.notes.dto;

import lombok.Value;

import java.util.List;

/**
 * @author viktar hraskou
 */
@Value

public class RecordDto {
    Long id;
    Long userId;
    String question;
    List<String> answers;
}
