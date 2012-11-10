package com.steventk.jpastudy;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="`CATEGORY`")
public class Category {
    private Long id;
    private Date lastModified;

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="`CATEGORY_ID`")
    public Long getId() {
        return id;
    }

    void setId(Long id) {
        this.id = id;
    }

    @Column(name="`LAST_MODIFIED`")
    @Temporal(TemporalType.TIMESTAMP)
    public Date getLastModified() {
        return lastModified;
    }

    void setLastModified(Date lastModified) {
        this.lastModified = lastModified;
    }
    
    
    @PrePersist
    @PreUpdate
    void updateTimestamps() {
        this.lastModified = new Date();
    }
}
