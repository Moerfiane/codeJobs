package org.stlyouthjobs.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
public class CandL {

    @Id
    @GeneratedValue
    private int id;

    @NotNull
    @Size(min = 3, max = 20, message = "Name must be between 3 and 20 Characters")
    private String name;

    @NotNull
    @Size(min = 2, max = 30)
    private String issuer;

    @NotNull
    private String issuedDate;

    public CandL() {
        this.id = id;
        this.name = name;
        this.issuer = issuer;
        this.issuedDate = issuedDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIssuer() {
        return issuer;
    }

    public void setIssuer(String issuer) {
        this.issuer = issuer;
    }

    public String getIssuedDate() {
        return issuedDate;
    }

    public void setIssuedDate(String issuedDate) {
        this.issuedDate = issuedDate;
    }
}
