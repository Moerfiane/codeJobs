package org.CodeJobs.models;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Applicant {

    @Id
    @GeneratedValue
    private int id;

    private int apply_Id;

    public Applicant(){}

    public int getId() {
        return id;
    }

    public int getApply_Id() {
        return apply_Id;
    }

    public void setApply_Id(int apply_Id) {
        this.apply_Id = apply_Id;
    }
}
