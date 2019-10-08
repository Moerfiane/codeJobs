package org.stlyouthjobs.models;


import org.hibernate.validator.constraints.Email;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import static javax.persistence.CascadeType.PERSIST;
import static javax.persistence.FetchType.EAGER;

@Entity
@Table(name = "EMPLOYER_USER")
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



    public EmployerUser() {
        this.email = email;
        this.confirmEmail = confirmEmail;
        this.password = password;
        this.confirmPassword= confirmPassword;
    }

    public UUID getUniqueID() {
        return uniqueID;
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
