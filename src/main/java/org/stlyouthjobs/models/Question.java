//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package org.stlyouthjobs.models;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Question {

    @OneToMany
    @JoinColumn(name = "question_id")
    private List<Answer> answer = new ArrayList<>();

    @Id
    @GeneratedValue
    private int id;
    @NotNull
    @Size(
            min = 1,
            max = 100
    )
    private String questionName;

    public Question(String questionName) {
        this.questionName = questionName;
    }

    public String getQuestionName() {
        return this.questionName;
    }

    public void setQuestionName(String questionName) {
        this.questionName = questionName;
    }

    public Question() {
    }

    public int getId() {
        return this.id;
    }
}