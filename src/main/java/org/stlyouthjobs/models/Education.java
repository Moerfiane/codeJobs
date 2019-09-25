package org.stlyouthjobs.models;

import oracle.jrockit.jfr.StringConstantPool;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Education {

    @Id
    @GeneratedValue
    private int id;

    @NotNull
    @Size(min=3, max=50)
    private String schoolName;

    @NotNull
    @Size(min=3, max=50)
    private String degree;

    @NotNull
    @Size(min=3, max=50)
    private String fieldOfStudy;

    @NotNull
    private String startDate;

    private String completionDate;

    @NotNull
    private String current;

    private String description;

    //empty constructor
    public Education(){}

    //parameter to set name of field
    public Education(String schoolName, String degree, String fieldOfStudy, String startDate,
                     String completionDate, String current, String description){
        this.schoolName = schoolName;
        this.degree = degree;
        this.fieldOfStudy = fieldOfStudy;
        this.startDate = startDate;
        this.completionDate = completionDate;
        this.current = current;
        this.description = description;
    }

    //Add once all controllers are added: @ManyToOne , @ManyToMany (Mapped by="")

    public int getId() {
        return id;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public String getFieldOfStudy() {
        return fieldOfStudy;
    }

    public void setFieldOfStudy(String fieldOfStudy) {
        this.fieldOfStudy = fieldOfStudy;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getCompletionDate() {
        return completionDate;
    }

    public void setCompletionDate(String completionDate) {
        this.completionDate = completionDate;
    }

    public String getCurrent() {
        return current;
    }

    public void setCurrent(String current) {
        this.current = current;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
