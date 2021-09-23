package com.vicras.notes.controller;

import com.google.protobuf.Empty;
import com.google.protobuf.Int64Value;
import com.vicras.notes.dto.RecordDto;
import com.vicras.notes.service.RecordService;
import com.vicras.proto_gen.note.Note;
import com.vicras.proto_gen.note.NoteControllerGrpc;
import com.vicras.proto_gen.note.Notes;
import io.grpc.stub.StreamObserver;
import lombok.RequiredArgsConstructor;
import net.devh.boot.grpc.server.service.GrpcService;

import java.util.stream.Stream;

/**
 * @author viktar hraskou
 */
@GrpcService
@RequiredArgsConstructor
public class NoteGrpcController extends NoteControllerGrpc.NoteControllerImplBase {

    private final RecordService recordService;

    @Override
    public void newRecord(Note request, StreamObserver<Empty> responseObserver) {
        RecordDto note = new RecordDto(request.getId(), request.getUserId(), request.getQuestion(), request.getAnswersList());
        recordService.createNewRecord(note);
        responseObserver.onNext(Empty.newBuilder().build());
        responseObserver.onCompleted();
    }

    @Override
    public void getById(Int64Value request, StreamObserver<Note> responseObserver) {
        RecordDto record = recordService.getDtoById(request.getValue());
        Note note = getNote(record);

        responseObserver.onNext(note);
        responseObserver.onCompleted();
    }

    private Note getNote(RecordDto record) {
        Note.Builder builder = Note.newBuilder()
                .setId(record.getId())
                .setUserId(record.getUserId())
                .setQuestion(record.getQuestion());

        record.getAnswers()
                .forEach(builder::addAnswers);
        return builder.build();
    }

    @Override
    public void deleteById(Int64Value request, StreamObserver<Empty> responseObserver) {
        try {
            recordService.deleteDtoById(request.getValue());
        } catch (Exception ignored) {
        }
        responseObserver.onNext(Empty.newBuilder().build());
        responseObserver.onCompleted();
    }

    @Override
    public void getAllByUserId(Int64Value request, StreamObserver<Notes> responseObserver) {
        Notes.Builder builder = Notes.newBuilder();
        recordService.getDtoByUserId(request.getValue()).stream()
                .map(this::getNote)
                .forEach(builder::addNotes);
        responseObserver.onNext(builder.build());
        responseObserver.onCompleted();
    }
}
