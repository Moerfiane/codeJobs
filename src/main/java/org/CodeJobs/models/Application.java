package org.CodeJobs.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
public class Application {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;

    @NotNull
    @Size (min = 3, max = 50)
    private String name;

    private Integer session;

    private String job_id;
    private String user_id;


    /* @ManyToMany
    @JoinTable(
            name = "apply_job",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "job_id")
    )
    Set<Job> applyJobs; */

    //empty constructor
    public Application(){}

    public Application(Integer session) {
        this.session = session;

    }

    public int getId() {
        return id;
    }

    public Integer getSession() {
        return session;
    }

    public void setSession(Integer session) {
        this.session = session;
    }
}
