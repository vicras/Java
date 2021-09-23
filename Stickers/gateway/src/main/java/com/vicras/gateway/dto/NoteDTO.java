package com.vicras.gateway.dto;

import lombok.Value;

import java.util.List;

/**
 * @author viktar hraskou
 */
@Value
public class NoteDTO {
    Long id;
    Long userId;
    String question;
    List<String> answers;
}
