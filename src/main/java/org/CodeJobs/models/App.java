package org.stlyouthjobs.models;

import javax.persistence.*;
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

    @NotNull
    private String address;

    @NotNull
    private String jobCategory;

    @NotNull
    private String location;

    @NotNull
    private String schedule;

    @NotNull
    private String jobSummary;

    @NotNull
    private String positionType;

    @NotNull
    private String numOfPositions;

    @NotNull
    private String dressCode;

    @NotNull
    private Double payRate;

    @NotNull
    private String closingDate;


    //empty constructor
    public App(){}

    public App(String name, String jobTitle, String address, String jobCategory, String location, String schedule,
               String jobSummary, String positionType, String numOfPositions, String dressCode, Double payRate, String closingDate) {
        this.name = name;
        this.jobTitle = jobTitle;
        this.address = address;
        this.jobCategory = jobCategory;
        this.location = location;
        this.schedule = schedule;
        this.jobSummary = jobSummary;
        this.positionType = positionType;
        this.numOfPositions = numOfPositions;
        this.dressCode = dressCode;
        this.payRate = payRate;
        this.closingDate = closingDate;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getJobCategory() {
        return jobCategory;
    }

    public void setJobCategory(String jobCategory) {
        this.jobCategory = jobCategory;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getSchedule() {
        return schedule;
    }

    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }

    public String getJobSummary() {
        return jobSummary;
    }

    public void setJobSummary(String jobSummary) {
        this.jobSummary = jobSummary;
    }

    public String getPositionType() {
        return positionType;
    }

    public void setPositionType(String positionType) {
        this.positionType = positionType;
    }

    public String getNumOfPositions() {
        return numOfPositions;
    }

    public void setNumOfPositions(String numOfPositions) {
        this.numOfPositions = numOfPositions;
    }

    public String getDressCode() {
        return dressCode;
    }

    public void setDressCode(String dressCode) {
        this.dressCode = dressCode;
    }

    public Double getPayRate() {
        return payRate;
    }

    public void setPayRate(Double payRate) {
        this.payRate = payRate;
    }

    public String getClosingDate() {
        return closingDate;
    }

    public void setClosingDate(String closingDate) {
        this.closingDate = closingDate;
    }
}
