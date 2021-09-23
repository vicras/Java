package com.vicras.gateway.controller;

import com.vicras.gateway.dto.NoteDTO;
import com.vicras.gateway.service.NoteService;
import com.vicras.proto_gen.note.Note;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.List;

import static java.util.stream.Collectors.toList;
import static org.springframework.http.ResponseEntity.ok;

/**
 * @author viktar hraskou
 */

@RestController
@RequestMapping("/gate")
@RequiredArgsConstructor
public class GatewayController {

    private final NoteService noteService;

    @PostMapping("/record")
    public ResponseEntity<Void> addRecord(@RequestBody NoteDTO noteDto, Principal principal) {
        noteService.newRecord(noteDto, principal);
        return ok().build();
    }

    @GetMapping("/records")
    public ResponseEntity<List<NoteDTO>> getRecords(Principal principal) {
        var allRecord = noteService.getAllRecord(principal).getNotesList().stream()
                .map(this::parseToDto)
                .collect(toList());
        return ok(allRecord);
    }

    private NoteDTO parseToDto(Note note) {
        return new NoteDTO(note.getId(), note.getUserId(), note.getQuestion(), note.getAnswersList());
    }
}
