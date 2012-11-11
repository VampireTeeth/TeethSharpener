package com.steventk.jpastudy;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;



//@MappedSuperclass //TABLE_PER_CLASS_IMPLICIT_POLYMOPHISM
@Entity
//@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)

@Table(name="`BILLING_DETAIL`")
//@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
//@DiscriminatorColumn(name="`BILLING_DETAIL_TYPE`", 
//    discriminatorType=DiscriminatorType.STRING)

@Inheritance(strategy=InheritanceType.JOINED)
public abstract class BillingDetail {
    
    @Id
    @GeneratedValue
    @Column(name = "`BILLING_DETAIL_ID`")
    private Long id;
    
    @Column(name="`OWNER`", nullable=false)
    private String owner;

    
    public Long getId() {
        return id;
    }

    void setId(Long id) {
        this.id = id;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }
    
    
    
    
}
