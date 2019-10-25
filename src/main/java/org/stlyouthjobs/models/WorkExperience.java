package org.stlyouthjobs.models;


import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class WorkExperience {

    @Id
    @GeneratedValue
    private int id;

    @NotNull
    @Size(min = 3, max = 50)
    private String jobTitle;

    @NotNull
    @Size(min = 3, max = 50)
    private String companyName;

    @NotNull
    @Size(min = 3, max = 50)
    private String location;

    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private String startDate;

    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private String endDate;

    private String current;

    @NotNull
    @Size(min = 3, max = 100)
    private String detail1;

    @Size(min = 3, max = 100)
    private String detail2;

    @Size(min = 3, max = 100)
    private String detail3;

    private Integer session;

    public WorkExperience() { }

    public WorkExperience(int id, String jobTitle, String companyName, String location, String startDate, String endDate, String current, String detail1, String detail2, String detail3, Integer session) {
        this.id = id;
        this.jobTitle = jobTitle;
        this.companyName = companyName;
        this.location = location;
        this.startDate = startDate;
        this.endDate = endDate;
        this.current = current;
        this.detail1 = detail1;
        this.detail2 = detail2;
        this.detail3 = detail3;
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

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getCurrent() {
        return current;
    }

    public void setCurrent(String current) {
        this.current = current;
    }

    public String getDetail1() {
        return detail1;
    }

    public void setDetail1(String detail1) {
        this.detail1 = detail1;
    }

    public String getDetail2() {
        return detail2;
    }

    public void setDetail2(String detail2) {
        this.detail2 = detail2;
    }

    public String getDetail3() {
        return detail3;
    }

    public void setDetail3(String detail3) {
        this.detail3 = detail3;
    }
}
