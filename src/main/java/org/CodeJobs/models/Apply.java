package org.CodeJobs.models;

import javax.persistence.*;


@Entity
public class Apply {

    @Id
    @GeneratedValue
    private int id;

    private int jobId;

    private int session;

    public Apply() {
    }

    public Apply(int id, int jobId, int session) {
        this.id = id;
        this.jobId = jobId;
        this.session = session;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getJobId() {
        return jobId;
    }

    public void setJobId(int jobId) {
        this.jobId = jobId;
    }

    public int getSession() {
        return session;
    }

    public void setSession(int session) {
        this.session = session;
    }
}
