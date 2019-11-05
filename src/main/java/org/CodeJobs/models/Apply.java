package org.CodeJobs.models;

import org.CodeJobs.models.Job;
import org.CodeJobs.models.User;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Set;

@Entity

public class Apply {

    @Id
    @GeneratedValue
    private int id;

    private int jobId;

    //empty constructor
    public Apply(){}

    public Apply(int jobId) {
        this.jobId = jobId;

    }

    public int getId() {
        return id;
    }

    public int getJobId() {
        return jobId;
    }

    public void setJobId(int jobId) {
        this.jobId = jobId;
    }
}
