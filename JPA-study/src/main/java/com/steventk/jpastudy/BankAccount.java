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
//@Table(name = "`BANK_ACCOUNT`")
//@AttributeOverride(name = "owner", column = @Column(name = "BANK_ACCOUNT_OWNER"))

//@DiscriminatorValue("BA")
@Table(name="`BANK_ACCOUNT`")
@PrimaryKeyJoinColumn(name="BANK_ACCOUNT_ID")
public class BankAccount extends BillingDetail {
//
//    @Id
//    @GeneratedValue
//    @Column(name="`BANK_ACCOUNT_ID`")
//    private Long id;
    
    @Column(name="`BANK_ACCOUNT`")
    private String account;

    @Column(name="`BANK_NAME`")
    private String bankName;

    @Column(name="`BANK_SWIFT`")
    private String swift;

    
//    public Long getId() {
//        return id;
//    }
//
//    void setId(Long id) {
//        this.id = id;
//    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getSwift() {
        return swift;
    }

    public void setSwift(String swift) {
        this.swift = swift;
    }
    
    

}
