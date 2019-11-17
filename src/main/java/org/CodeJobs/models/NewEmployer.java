package org.CodeJobs.models;


import org.hibernate.validator.constraints.Email;

import javax.persistence.*;
import javax.validation.constraints.*;


@Entity
@Table(name = "NEW_EMPLOYER")
public class NewEmployer {

    @NotNull
    @Size(min = 3, max = 30, message = "This field is required.")
    private String organizationName;

    @NotNull
    @Size(min = 2, max = 30, message = "Contact name is required")
    private String contactName;

    @NotNull
    @Size(min = 3, max = 25, message = "This field is required.")
    private String website;

    @NotNull(message = "Invalid EIN")

    @Pattern(regexp = "\\d{9}|(?:\\d{2}-){2}\\d{7}", message = "Incorrect format")
    private Long ein;

    @NotNull(message = "Invalid phone number")
    @Pattern(regexp = "\\d{10}|(?:\\d{3}-){2}\\d{4}|\\(\\d{3}\\)\\d{3}-?\\d{4}")
    private Long phoneNumber;

    @NotNull
    @Email
    private String email;

    @NotNull
    @Email
    private String confirmEmail;


    @Id
    @GeneratedValue
    private int id;

    private Integer session;


    public NewEmployer () {}

    public NewEmployer(String organizationName, String contactName, String website, Long ein, Long phoneNumber, String email, String confirmEmail, int id, Integer session) {
        this.organizationName = organizationName;
        this.contactName = contactName;
        this.website = website;
        this.ein = ein;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.confirmEmail = confirmEmail;
        this.id = id;
        this.session = session;
    }

    public Integer getSession() {
        return session;
    }

    public void setSession(Integer session) {
        this.session = session;
    }

    public int getId() {
        return id;
    }

    public String getOrganizationName() {
        return organizationName;
    }

    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public Long getEin() {
        return ein;
    }

    public void setEin(Long ein) {
        this.ein = ein;
    }

    public Long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getConfirmEmail() {
        return confirmEmail;
    }

    public void setConfirmEmail(String confirmEmail) {
        this.confirmEmail = confirmEmail;
    }

}
