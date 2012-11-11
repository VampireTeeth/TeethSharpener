package com.steventk.jpastudy;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Address {
    private String street;

    private String zipcode;

    private String city;

    @Column(name="`ADDRESS_STREET`")
    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    @Column(name="`ADDRESS_ZIP_CODE`")
    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    @Column(name="`ADDRESS_CITY`")
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

}
