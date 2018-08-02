package com.example.sweater.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Test2 {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;
    private String string;

    public Test2(String string) {
        this.string = string;
    }

    public Test2() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getString() {
        return string;
    }

    public void setString(String string) {
        this.string = string;
    }
}
