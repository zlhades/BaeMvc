package com.demo.domain;

import javax.persistence.Entity;

@Entity
public class Product
        extends AbstractPersistence
{

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
