package com.dipakkr.github.sqliteexample.model;

/**
 * Created by root on 6/7/17.
 */

public class Student {
    public int id;
    public String name;
    public String subject;

    public Student(){

    }

    public Student(int id,String name,String subject){
        this.id = id;
        this.name=name;
        this.subject = subject;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
}
