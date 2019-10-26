package org.stlyouthjobs.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Statement {

    @Id
    @GeneratedValue
    private int id;

    @NotNull
    @Size(min = 3, max = 500)
    private String description;

    private Integer session;

    public Statement() { }

    public Statement(int id, String description, Integer session) {
        this.id = id;
        this.description = description;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}