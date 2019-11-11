package org.CodeJobs.models;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Applicant {

    @Id
    @GeneratedValue
    private int id;

    private int applyId;

    private int session;


    public Applicant(){}

    public Applicant(int id, int applyId, int session) {
        this.id = id;
        this.applyId = applyId;
        this.session = session;
    }

    public int getId() {
        return id;
    }

    public int getApplyId() {
        return applyId;
    }

    public void setApplyId(int applyId) {
        this.applyId = applyId;
    }

    public int getSession() {
        return session;
    }

    public void setSession(int session) {
        this.session = session;
    }
}
