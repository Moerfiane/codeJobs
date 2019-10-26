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

    private Integer session;

    public AboutMe() { }

    public AboutMe(int id, String text, Integer session) {
        this.id = id;
        this.text = text;
        this.session = session;
    }

    public Integer getSession() {
        return session;
    }

    public void setSession(Integer session) {
        this.session = session;
    }

    public int getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}

