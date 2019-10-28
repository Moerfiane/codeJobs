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
    private Integer session;

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



    public Education(){}

    public Education(String schoolName, String degree, String startDate, String completionDate, String current, Integer session) {

        this.schoolName = schoolName;
        this.degree = degree;
        this.startDate = startDate;
        this.completionDate = completionDate;
        this.current = current;
        this.session = session;
    }

    public Integer getSession() {
        return session;
    }

    public void setSession(Integer session) {
        this.session = session;
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
