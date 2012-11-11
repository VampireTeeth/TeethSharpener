package com.steventk.jpastudy;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="`USER`")
public class User {
    private Long id;
    
    private String firstName;

    private String lastName;

    private Address homeAddress;

    private Address billingAddress;

    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="`USER_ID`")
    public Long getId() {
        return id;
    }

    void setId(Long id) {
        this.id = id;
    }

    @Column(name="`FIRST_NAME`")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Column(name="`LAST_NAME`")
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Embedded
    @AttributeOverrides({
        @AttributeOverride(name="street", column=@Column(name="`HOME_STREET`")),
        @AttributeOverride(name="zipcode", column=@Column(name="`HOME_ZIP_CODE`")),
        @AttributeOverride(name="city", column=@Column(name="`HOME_CITY`"))
    })
    public Address getHomeAddress() {
        return homeAddress;
    }

    public void setHomeAddress(Address homeAddress) {
        this.homeAddress = homeAddress;
    }

    @Embedded
    @AttributeOverrides({
        @AttributeOverride(name="street", column=@Column(name="`BILLING_STREET`")),
        @AttributeOverride(name="zipcode", column=@Column(name="`BILLING_ZIP_CODE`")),
        @AttributeOverride(name="city", column=@Column(name="`BILLING_CITY`"))
    })
    public Address getBillingAddress() {
        return billingAddress;
    }

    public void setBillingAddress(Address billingAddress) {
        this.billingAddress = billingAddress;
    }

}
