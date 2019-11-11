package org.CodeJobs.models;

import javax.persistence.*;


@Entity
public class Apply {

    @Id
    @GeneratedValue
    private int id;

    private int job_Id;

    private int session;

    public Apply() {
    }

    public int getJob_Id() {
        return job_Id = job_Id;
    }

    public void setJob_Id(int job_Id) {
        this.job_Id = job_Id;
    }

    public void setSession(int session) {
        this.session = session;
    }

    public int getId() {
        return id;
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
