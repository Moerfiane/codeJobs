package org.stlyouthjobs.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Skills {

    @Id
    private Integer session;

    @NotNull
    @Size(max=50)
    private String language1;

    @Size(max=50)
    private String language2;

    @Size(max=50)
    private String language3;

    @Size(max=50)
    private String language4;

    @Size(max=50)
    private String language5;

    @Size(max=50)
    private String language6;

    @NotNull
    @Size(max=50)
    private String framework1;

    @Size(max=50)
    private String framework2;

    @Size(max=50)
    private String framework3;

    @Size(max=50)
    private String framework4;

    @Size(max=50)
    private String framework5;

    @Size(max=50)
    private String framework6;

    @NotNull
    @Size(max=50)
    private String database1;

    @Size(max=50)
    private String database2;

    @Size(max=50)
    private String database3;

    @NotNull
    @Size(max=50)
    private String tool1;

    @Size(max=50)
    private String tool2;

    @Size(max=50)
    private String tool3;


    public Skills() {}

    public Skills(String language1, String language2, String language3,
                  String language4, String language5, String language6, String framework1,
                  String framework2, String framework3, String framework4, String framework5,
                  String framework6, String database1, String database2, String database3,
                  String tool1, String tool2, String tool3, Integer session) {
        this.language1 = language1;
        this.language2 = language2;
        this.language3 = language3;
        this.language4 = language4;
        this.language5 = language5;
        this.language6 = language6;
        this.framework1 = framework1;
        this.framework2 = framework2;
        this.framework3 = framework3;
        this.framework4 = framework4;
        this.framework5 = framework5;
        this.framework6 = framework6;
        this.database1 = database1;
        this.database2 = database2;
        this.database3 = database3;
        this.tool1 = tool1;
        this.tool2 = tool2;
        this.tool3 = tool3;
        this.session = session;
    }

    public Integer getSession() {
        return session;
    }

    public void setSession(Integer session) {
        this.session = session;
    }


    public String getLanguage1() {
        return language1;
    }

    public void setLanguage1(String language1) {
        this.language1 = language1;
    }

    public String getLanguage2() {
        return language2;
    }

    public void setLanguage2(String language2) {
        this.language2 = language2;
    }

    public String getLanguage3() {
        return language3;
    }

    public void setLanguage3(String language3) {
        this.language3 = language3;
    }

    public String getLanguage4() {
        return language4;
    }

    public void setLanguage4(String language4) {
        this.language4 = language4;
    }

    public String getLanguage5() {
        return language5;
    }

    public void setLanguage5(String language5) {
        this.language5 = language5;
    }

    public String getLanguage6() {
        return language6;
    }

    public void setLanguage6(String language6) {
        this.language6 = language6;
    }

    public String getFramework1() {
        return framework1;
    }

    public void setFramework1(String framework1) {
        this.framework1 = framework1;
    }

    public String getFramework2() {
        return framework2;
    }

    public void setFramework2(String framework2) {
        this.framework2 = framework2;
    }

    public String getFramework3() {
        return framework3;
    }

    public void setFramework3(String framework3) {
        this.framework3 = framework3;
    }

    public String getFramework4() {
        return framework4;
    }

    public void setFramework4(String framework4) {
        this.framework4 = framework4;
    }

    public String getFramework5() {
        return framework5;
    }

    public void setFramework5(String framework5) {
        this.framework5 = framework5;
    }

    public String getFramework6() {
        return framework6;
    }

    public void setFramework6(String framework6) {
        this.framework6 = framework6;
    }

    public String getDatabase1() {
        return database1;
    }

    public void setDatabase1(String database1) {
        this.database1 = database1;
    }

    public String getDatabase2() {
        return database2;
    }

    public void setDatabase2(String database2) {
        this.database2 = database2;
    }

    public String getDatabase3() {
        return database3;
    }

    public void setDatabase3(String database3) {
        this.database3 = database3;
    }

    public String getTool1() {
        return tool1;
    }

    public void setTool1(String tool1) {
        this.tool1 = tool1;
    }

    public String getTool2() {
        return tool2;
    }

    public void setTool2(String tool2) {
        this.tool2 = tool2;
    }

    public String getTool3() {
        return tool3;
    }

    public void setTool3(String tool3) {
        this.tool3 = tool3;
    }

}
