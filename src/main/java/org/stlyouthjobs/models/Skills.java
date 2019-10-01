package org.stlyouthjobs.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Skills {

    @Id
    @GeneratedValue
    private int id;

    @NotNull
    @Size(min=3, max=50)
    private String name;

    //empty contructor
    public Skills(){}

    //parameter to set name of field
    public Skills(String name) {
        this.name = name;
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
}
