package org.stlyouthjobs.models;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Answer {

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Id
    @GeneratedValue
    private int id;

    @NotNull
    @Size(min=1, max=100)
    private String name;

    @OneToMany
    @JoinColumn(name = "answer_id")
    private List<Question> Question = new ArrayList<>();

    public Answer() { }

    public Answer(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

}
