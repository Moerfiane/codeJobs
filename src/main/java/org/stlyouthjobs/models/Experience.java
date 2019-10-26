package org.stlyouthjobs.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Experience {

    //      * Job Title
    //      * Company
    //      * Start date (MM/DD/YYYY)
    //      * End Date (MM/DD/YYYY)
    //      * I currently work here (checkbox)
    //         * If currently working there - end date not required
    //      * Description  (character limit)
    @Id
    @GeneratedValue
    private int id;

    @NotNull
    @Size(min = 2, max = 20, message = "Job title must not be Empty.")
    private String jobTitle;

    @NotNull
    @Size(min = 2, max = 50, message = "Company name must not be empty.")
    private String company;

    @NotNull
    private String startDate;

    private String endDate;

    @NotNull
    @Size(min = 2, max = 2500, message = "Description must not be empty.")
    private String description;

    private Integer session;

    public Experience() { }

    public Experience(int id, String jobTitle, String company, String startDate, String endDate, String description, Integer session) {
        this.id = id;
        this.jobTitle = jobTitle;
        this.company = company;
        this.startDate = startDate;
        this.endDate = endDate;
        this.description = description;
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

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
