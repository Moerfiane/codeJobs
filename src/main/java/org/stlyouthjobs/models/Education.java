package org.stlyouthjobs.models;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
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
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private String startDate;

    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private String completionDate;

    private String current;


    //empty constructor
    public Education(){}

    //parameter to set name of field
    public Education(String schoolName, String degree, String startDate,
                     String completionDate, String current){
        this.schoolName = schoolName;
        this.degree = degree;
        this.startDate = startDate;
        this.completionDate = completionDate;
        this.current = current;
    }

    //only a getter for id. other classes shouldn't be able to change the id.
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

}
