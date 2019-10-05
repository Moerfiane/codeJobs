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
@Table(name = "USER")
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

    @NotNull
    @Email
    private String email;

    @NotNull
    @Email
    private String confirmEmail;

    @NotNull
    @Size(max = 2500, message = "This field is required.")
    private String password;

    @NotNull
    @Size(max = 2500, message = "This field is required.")
    private String confirmPassword;

    @NotNull
    @Size(min=1, max=10, message = "Street number must have at least one number.")
    private Integer streetNumber;

    @NotNull
    @Size(max = 2500, message = "This field is required.")
    private String streetName;

    @NotNull
    @Size(max = 2500, message = "This field is required.")
    private String city;

    @NotNull
    @Size(max = 9, message = "This field is required.")
    private Integer zipCode;

    @NotNull
    @Size(max = 2500, message = "This field is required.")
    private String neighborhood;

    @Id
    @GeneratedValue
    private String uniqueID = UUID.randomUUID().toString();

    @ManyToMany(mappedBy =  "newEmployers", cascade = PERSIST, fetch = EAGER)
    private Set<User> users = new HashSet<>();

    public Set<User> getUsers() {
        return users;
    }

    public void addUser(User user) {
        users.add(user);
        user.getNewEmployer().add(this);
    }
    public NewEmployer () {}

    public NewEmployer(String organizationName, String contactName, String website, Long ein, Long phoneNumber,
                       String email, String confirmEmail, String password, String confirmPassword, Integer streetNumber,
                       String streetName, String city, Integer zipCode, String neighborhood) {
        this.organizationName = organizationName;
        this.contactName = contactName;
        this.website = website;
        this.ein = ein;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.confirmEmail = confirmEmail;
        this.password = password;
        this.confirmPassword= confirmPassword;
        this.streetNumber = streetNumber;
        this.streetName = streetName;
        this.city = city;
        this.zipCode = zipCode;
        this.neighborhood = neighborhood;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public Integer getStreetNumber() {
        return streetNumber;
    }

    public void setStreetNumber(Integer streetNumber) {
        this.streetNumber = streetNumber;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Integer getZipCode() {
        return zipCode;
    }

    public void setZipCode(Integer zipCode) {
        this.zipCode = zipCode;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }
}
