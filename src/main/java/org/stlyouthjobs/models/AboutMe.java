package org.stlyouthjobs.models;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class AboutMe {

    @Id
    @GeneratedValue
    private int id;

    @NotNull
    @Size(max = 2500, message = "About me field must not be empty.")
    private String text;

    public AboutMe() {
        this.id = id;
        this.text = text;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}

