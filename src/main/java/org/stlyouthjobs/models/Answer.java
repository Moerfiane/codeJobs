//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package org.stlyouthjobs.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Answer {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )

    private int id;
    @NotNull
    @Size(
            min = 1,
            max = 100
    )
    private String answerName;

    private Boolean tof;

    @ManyToOne
    private Question question;

    public Answer() {
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public Boolean getTof() {
        return tof;
    }

    public void setTof(Boolean tof) {
        this.tof = tof;
    }

    public Answer(String answerName) {
        this.answerName = answerName;
    }

    public String getAnswerName() {
        return this.answerName;
    }

    public void setAnswerName(String answerName) {
        this.answerName = answerName;
    }

    public int getId() {
        return this.id;
    }
}