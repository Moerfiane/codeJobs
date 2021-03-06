package org.CodeJobs.models;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "ADDRESS")
public class Address {

    @Id
    @GeneratedValue
    private int id;

    @NotNull
    //@Size(min=1, max=10, message = "Street number must have at least one number.")
    private Integer streetNumber;

    @NotNull
    @Size(max = 2500, message = "This field is required.")
    private String streetName;

    @NotNull
    @Size(max = 2500, message = "This field is required.")
    private String city;

    @NotNull
    //@Size(max = 9, message = "This field is required.")
    private Integer zipCode;

    @NotNull
    @Size(max = 2500, message = "This field is required.")
    private String neighborhood;

    private Integer session;


    public Address() { }

    public Address(int id, Integer streetNumber, String streetName, String city, Integer zipCode, String neighborhood, Integer session) {
        this.id = id;
        this.streetNumber = streetNumber;
        this.streetName = streetName;
        this.city = city;
        this.zipCode = zipCode;
        this.neighborhood = neighborhood;
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
