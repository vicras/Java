package com.vicras.notes.domain;

import com.vicras.lib.domain.BaseEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.List;

/**
 * @author viktar hraskou
 */
@Getter
@Setter
@Entity
@ToString
@NoArgsConstructor
@Table(name = "record")
public class Record extends BaseEntity {

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "question")
    private String question;

    @Convert(converter = AnswersConverter.class)
    @Column(name = "answer")
    private List<String> answers;

    @Builder
    public Record(Long userId, String question, List<String> answers) {
        super();
        this.userId = userId;
        this.question = question;
        this.answers = answers;
    }
}
