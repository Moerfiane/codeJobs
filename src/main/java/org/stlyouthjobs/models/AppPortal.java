package org.stlyouthjobs.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class AppPortal {

    @Id
    @GeneratedValue
    public int id;

    @NotNull
    public String name;

    @NotNull
    public String jobTitle;

    public AppPortal(){}

    public AppPortal(String name, String jobTitle){
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
