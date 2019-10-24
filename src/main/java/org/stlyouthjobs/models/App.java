package org.stlyouthjobs.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class App {

    @Id
    @GeneratedValue
    private int id;

    @NotNull
    @Size(min=3, max=60)
    private String name;

    @NotNull
    private String jobTitle;

    //empty constructor
    public App(){}

    public App(String name, String jobTitle) {
        this.name = name;
        this.jobTitle = jobTitle;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }
}
