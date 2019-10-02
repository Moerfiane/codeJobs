package org.stlyouthjobs.models;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class NewEmployer {

    @Id
    @GeneratedValue
    private int id;

    @NotNull
    @Size(max = 2500, message = "This field is required.")
    private String text;

}
