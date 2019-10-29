package org.CodeJobs.models;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.annotation.Generated;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;


@Entity
public class User extends AbstractEntity {

    @NotNull
    private String username;

    @NotNull
    private String pwHash;
    private static final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    private String access;

    public User(){
    }

    public User(String username, String password, String access) {
        this.username = username;
        this.pwHash = hashPassword(password);
        this.access = access;
    }

    public String getAccess() {
        return access;
    }

    public String getUsername() {
        return username;
    }

    private static String hashPassword(String password) {
        return encoder.encode(password);
    }

    public boolean isMatchingPassword(String password) {
        return encoder.matches(password, pwHash);
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setAccess(String access) {
        this.access = access;
    }
}
