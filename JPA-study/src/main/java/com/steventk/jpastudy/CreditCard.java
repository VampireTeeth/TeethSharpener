package com.steventk.jpastudy;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
//@Table(name="`CREDIT_CARD`")
//@AttributeOverride(name="owner", column=@Column(name="`CC_OWNER`"))

//@DiscriminatorValue("CC")

@Table(name="`CREDIT_CARD`")
@PrimaryKeyJoinColumn(name="`CREDIT_CARD_ID`")
public class CreditCard extends BillingDetail{
    
//    @Id
//    @GeneratedValue
//    @Column(name="`CC_ID`")
//    private Long id;
    
    @Column(name="`CC_NUMBER`")
    private String number;
    
    @Column(name="`EXPIRY_MONTH`")
    private String expMonth;
    
    @Column(name="`EXPIRY_YEAR`")
    private String expYear;

//    public Long getId() {
//        return id;
//    }
//
//    void setId(Long id) {
//        this.id = id;
//    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getExpMonth() {
        return expMonth;
    }

    public void setExpMonth(String expMonth) {
        this.expMonth = expMonth;
    }

    public String getExpYear() {
        return expYear;
    }

    public void setExpYear(String expYear) {
        this.expYear = expYear;
    }
    
    
}
