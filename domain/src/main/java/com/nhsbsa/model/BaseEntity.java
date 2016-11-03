package com.nhsbsa.model;

import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by matthewhood on 17/08/2016.
 * 
 */

@ToString
@EqualsAndHashCode
public abstract class BaseEntity<T> implements Serializable {

    private String createdBy;
    private Date createdOn;

    protected String updatedBy;
    protected Date updatedOn;

    protected int recStatus;
    protected boolean locked;

    abstract T getId();

    @PrePersist
    private void prePersist() {
        createdBy = "system_persist";
        createdOn = new Date();
        recStatus = 1;
        locked = false;
    }

    @PreUpdate
    private void preUpdate() {
        updatedBy = "system_update";
        updatedOn = new Date();
    }

}
