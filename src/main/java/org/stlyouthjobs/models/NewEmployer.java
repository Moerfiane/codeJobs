package org.stlyouthjobs.models;


import org.hibernate.validator.constraints.Email;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import static javax.persistence.CascadeType.PERSIST;
import static javax.persistence.FetchType.EAGER;

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

    @NotNull
    @Pattern(regexp = "\\d{9}|(?:\\d{2}-){2}\\d{7}",
            message = "Invalid EIN")
    private Long ein;

    @NotNull
    @Pattern(regexp = "\\d{10}|(?:\\d{3}-){2}\\d{4}|\\(\\d{3}\\)\\d{3}-?\\d{4}",
            message = "Invalid phone number")
    private Long phoneNumber;


    @Id
    @GeneratedValue
    private int id;

    @ManyToMany(mappedBy =  "newEmployers", cascade = PERSIST, fetch = EAGER)
    private Set<EmployerUser> employerUsers = new HashSet<>();

    public Set<EmployerUser> getEmployerUsers() {
        return employerUsers;
    }

    public void addEmployerUser(EmployerUser employerUser) {
        employerUsers.add(employerUser);
        employerUser.getNewEmployer().add(this);
    }
    public NewEmployer () {}

    public NewEmployer(String organizationName, String contactName, String website, Long ein, Long phoneNumber) {
        this.organizationName = organizationName;
        this.contactName = contactName;
        this.website = website;
        this.ein = ein;
        this.phoneNumber = phoneNumber;
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

}
