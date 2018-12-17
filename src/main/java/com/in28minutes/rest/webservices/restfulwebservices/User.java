/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.in28minutes.rest.webservices.restfulwebservices;

import java.util.Date;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

/**
 *
 * @author 0011539
 */


public class User {
    private Integer id;
    
    @Size (min = 2, message = "Nombre debe tener al menos dos caracteres")
    private String name;
    
    @Past
    private Date birthday;

    public User() {
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

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", name=" + name + ", birthday=" + birthday + '}';
    }

    public User(Integer id, String name, Date birthday) {
        this.id = id;
        this.name = name;
        this.birthday = birthday;
    }
    
    
}
