package org.stlyouthjobs.models;


import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.URL;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class NewApplicant {

    @Id
    @GeneratedValue
    private int id;

    @NotNull
    @URL
    @Size(min = 2, max = 100)
    private String gitHub;

    @NotNull
    @URL
    @Size(min = 2, max = 100)
    private String linkedIn;


    public NewApplicant() {
        this.id = id;
        this.gitHub = gitHub;
        this.linkedIn = linkedIn;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGitHub() {
        return gitHub;
    }

    public void setGitHub(String gitHub) {
        this.gitHub = gitHub;
    }

    public String getLinkedIn() {
        return linkedIn;
    }

    public void setLinkedIn(String linkedIn) {
        this.linkedIn = linkedIn;
    }
}
