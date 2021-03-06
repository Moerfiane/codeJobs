package org.CodeJobs.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Statement {

    @Id
//    @GeneratedValue
//    private int id;
    private Integer session;

    @NotNull
    @Size(min = 3, max = 500)
    private String description;

//    private Integer session;

    public Statement() { }

    public Statement(String description, Integer session) {

        this.description = description;
        this.session = session;
    }

    public Integer getSession() {
        return session;
    }

    public void setSession(Integer session) {
        this.session = session;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}