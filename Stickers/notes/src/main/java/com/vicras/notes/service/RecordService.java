package com.vicras.notes.service;

import com.vicras.notes.dto.RecordDto;

import java.util.List;

/**
 * @author viktar hraskou
 */
public interface RecordService {
    void createNewRecord(RecordDto recordDto);

    RecordDto getDtoById(Long id);

    List<RecordDto> getDtoByUserId(Long id);

    void deleteDtoById(Long id);

    void updateDto(RecordDto recordDto);
}
