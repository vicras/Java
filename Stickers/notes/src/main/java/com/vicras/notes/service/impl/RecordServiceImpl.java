package com.vicras.notes.service.impl;

import com.vicras.lib.exceptions.EntityNotFoundException;
import com.vicras.notes.domain.Record;
import com.vicras.notes.dto.RecordDto;
import com.vicras.notes.repository.RecordRepository;
import com.vicras.notes.service.RecordService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * @author viktar hraskou
 */
@Service
@RequiredArgsConstructor
public class RecordServiceImpl implements RecordService {

    private final RecordRepository recordRepository;

    @Override
    public void createNewRecord(RecordDto recordDto) {
        var record = fromDto(recordDto);
        recordRepository.save(record);
    }

    private Record fromDto(RecordDto recordDto) {
        return Record.builder()
                .question(recordDto.getQuestion())
                .answers(recordDto.getAnswers())
                .userId(recordDto.getUserId())
                .build();
    }

    @Override
    public RecordDto getDtoById(Long id) {
        return recordRepository.findById(id)
                .map(this::toDto)
                .orElseThrow(() -> new EntityNotFoundException(Record.class, id));
    }

    @Override
    public List<RecordDto> getDtoByUserId(Long id) {
        return recordRepository.findAllByUserId(id)
                .stream().map(this::toDto)
                .collect(toList());
    }

    private RecordDto toDto(Record record) {
        return new RecordDto(
                record.getId(),
                record.getUserId(),
                record.getQuestion(),
                record.getAnswers()
        );
    }

    @Override
    public void deleteDtoById(Long id) {
        recordRepository.deleteById(id);
    }

    @Override
    public void updateDto(RecordDto recordDto) {
        Record record = recordRepository.getById(recordDto.getId());
        record.setAnswers(recordDto.getAnswers());
        record.setQuestion(recordDto.getQuestion());
        record.setUserId(recordDto.getUserId());
        recordRepository.save(record);
    }
}
