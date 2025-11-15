package com.es.spainapi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Transient;

import java.io.Serializable;

@MappedSuperclass
public abstract class BaseEntity <ID extends Serializable> {

    @JsonIgnore
    public abstract ID getID();

}
