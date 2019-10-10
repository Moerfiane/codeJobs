package org.stlyouthjobs.models;


import org.hibernate.validator.constraints.Email;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.*;

import static javax.persistence.CascadeType.PERSIST;
import static javax.persistence.FetchType.EAGER;

@Entity
@Table(name = "EMPLOYER_USER")
/*@SecondaryTables({
        @SecondaryTable(name = "ADDRESS", pkJoinColumns = @PrimaryKeyJoinColumn(name = "ADDRESS_ID")),
        @SecondaryTable(name = "NEW_EMPLOYER", pkJoinColumns = @PrimaryKeyJoinColumn(name = "NEW_EMPLOYER_ID"))
})*/
public class EmployerUser {
    @Id
    @GeneratedValue
    private UUID uniqueID = UUID.randomUUID();

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

    @OneToMany
    @JoinColumn(name = "address_id")
    private List<Address> Addresses = new ArrayList<>();

    @OneToMany
    @JoinColumn(name = "newEmployer_id")
    private List<NewEmployer> newEmployers = new ArrayList<>();



    public EmployerUser() {
    }


    public EmployerUser(UUID uniqueID, String email, String confirmEmail, String password, String confirmPassword) {
        this.uniqueID = uniqueID;
        this.email = email;
        this.confirmEmail = confirmEmail;
        this.password = password;
        this.confirmPassword = confirmPassword;
    }

    public UUID getUniqueID() {
        return uniqueID;
    }

    public void setUniqueID(UUID uniqueID) {
        this.uniqueID = uniqueID;
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
}
