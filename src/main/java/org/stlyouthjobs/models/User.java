package org.stlyouthjobs.models;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.List;

/**
 * Created by LaunchCode
 */
/*@Entity
public class User extends AbstractEntity {

    @NotNull

    private String username;

    @NotNull
    private String pwHash;
    private static final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    @OneToMany
    @JoinColumn(name = "owner_uid")
    private List<Cheese> cheeses;

    private String access;

    public User(){
    }

    public User(String username, String password, String access) {
        this.username = username;
        this.pwHash = hashPassword(password);
        this.access = access;
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

    protected void addCheese(Cheese cheese) {
        cheeses.add(cheese);
    }

    public List<Cheese> getCheeses() {
        return cheeses;
    }

}*/
