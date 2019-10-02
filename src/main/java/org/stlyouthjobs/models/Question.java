package org.stlyouthjobs.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by LaunchCode
 */
@Entity
public class Question {

    @Id
    @GeneratedValue
    private int id;

    @NotNull
    @Size(min=1, max=100)
    private String name;

    @ManyToOne
    private Answer answer;

//    @ManyToMany(mappedBy = "questions")
//    private List<Question> questions;

    public Question(String name) {
        this.name = name;
        
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Question() { }

    public int getId() {
        return id;
    }


    public void setAnswer(Answer answer) {
        this.answer = answer;
    }

    public Answer getAnswer() {
        return answer;
    }
}