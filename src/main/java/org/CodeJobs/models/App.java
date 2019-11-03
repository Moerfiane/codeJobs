package org.CodeJobs.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
public class App {

    @Id
    @GeneratedValue
    private int id;

    private Integer job_Id;

    private Integer session;

    public App() {
    }

    public App(Integer job_Id, Integer session) {
        this.job_Id = job_Id;
        this.session = session;
    }

    public int getId() {
        return id;
    }

    public Integer getJob_Id() {
        return job_Id;
    }

    public void setJob_Id(Integer job_Id) {
        this.job_Id = job_Id;
    }

    public Integer getSession() {
        return session;
    }

    public void setSession(Integer session) {
        this.session = session;
    }
}
