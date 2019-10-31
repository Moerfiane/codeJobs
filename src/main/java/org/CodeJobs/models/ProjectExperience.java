package org.CodeJobs.models;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class ProjectExperience {

    @Id
    private Integer session;

    @NotNull
    @Size(min = 3, max = 50)
    private String name;

    @NotNull
    @Size(min = 3, max = 500)
    private String summary;

    @NotNull
    @Size(min = 3, max = 100)
    private String detail1;

    @Size(max = 100)
    private String detail2;

    @Size(max = 100)
    private String detail3;



    public ProjectExperience() { }

    public ProjectExperience(String name, String summary, String detail1, String detail2, String detail3, Integer session) {
        this.name = name;
        this.summary = summary;
        this.detail1 = detail1;
        this.detail2 = detail2;
        this.detail3 = detail3;
        this.session = session;
    }

    public Integer getSession() {
        return session;
    }

    public void setSession(Integer session) {
        this.session = session;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getDetail1() {
        return detail1;
    }

    public void setDetail1(String detail1) {
        this.detail1 = detail1;
    }

    public String getDetail2() {
        return detail2;
    }

    public void setDetail2(String detail2) {
        this.detail2 = detail2;
    }

    public String getDetail3() {
        return detail3;
    }

    public void setDetail3(String detail3) {
        this.detail3 = detail3;
    }
}
