package org.CodeJobs.models;

import javax.persistence.*;


@Entity
public class Apply {

    @Id
    @GeneratedValue
    private int id;

    private Integer job_Id;

    private Integer session;

    public Apply() {
    }

    public Apply(Integer jobId, Integer session) {
        this.job_Id = job_Id;
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
