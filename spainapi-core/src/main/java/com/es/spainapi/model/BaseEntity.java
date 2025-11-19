package com.es.spainapi.model;

import jakarta.persistence.MappedSuperclass;

import java.io.Serializable;

@MappedSuperclass
public abstract class BaseEntity <ID extends Serializable> {

    public abstract ID getID();

}
