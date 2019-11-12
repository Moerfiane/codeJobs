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

    public Apply(int id, int job_Id, int session) {
        this.id = id;
        this.job_Id = job_Id;
        this.session = session;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getJob_Id() {
        return job_Id;
    }

    public void setJob_Id(int job_Id) {
        this.job_Id = job_Id;
    }

    public int getSession() {
        return session;
    }

    public void setSession(int session) {
        this.session = session;
    }
}
