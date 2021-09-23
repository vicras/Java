package com.vicras.gateway.service;

import com.google.protobuf.Int64Value;
import com.vicras.gateway.dto.NoteDTO;
import com.vicras.proto_gen.note.Note;
import com.vicras.proto_gen.note.NoteControllerGrpc;
import com.vicras.proto_gen.note.Notes;
import lombok.RequiredArgsConstructor;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.stereotype.Service;

import java.security.Principal;

/**
 * @author viktar hraskou
 */
@Service
@RequiredArgsConstructor
public class NoteService {

    @GrpcClient("note-grpc-server")
    private NoteControllerGrpc.NoteControllerBlockingStub noteController;


    public void newRecord(NoteDTO noteDTO, Principal principal) {

        Note.Builder builder = Note.newBuilder()
                .setUserId(Long.parseLong(principal.getName()))
                .setQuestion(noteDTO.getQuestion());
        noteDTO.getAnswers().forEach(builder::addAnswers);

        noteController.newRecord(builder.build());
    }

    public Notes getAllRecord(Principal principal) {
        long id = Long.parseLong(principal.getName());

        return noteController.getAllByUserId(Int64Value.of(id));
    }

}
