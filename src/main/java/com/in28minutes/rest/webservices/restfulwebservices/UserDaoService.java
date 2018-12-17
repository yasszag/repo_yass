/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.in28minutes.rest.webservices.restfulwebservices;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import org.springframework.stereotype.Component;

/**
 *
 * @author 0011539
 */
@Component
public class UserDaoService {
    private static  List<User> users = new ArrayList<>();
    
    private int count = 3;
    
    static {
        users.add(new User(1, "Aadam", new Date()));
        users.add(new User(2, "Eve", new Date()));
        users.add(new User(3, "Jack", new Date()));
        
        }
        
    public List<User> FindAll(){
        return users;
    }
    
    public User SaveUser(User user){
        if (user.getId() == null) {
            user.setId(count++);
        }
        users.add(user);
        return user;
    }
    
    public User FindOne(int id){
        for (User user : users) {
            if (user.getId() == id) {
                return user;
            }       
        }
        return null;
    }
    
    public User DeketeById(int id){
        Iterator<User> iterator = users.iterator();
        while (iterator.hasNext()) {
            User user = iterator.next();
            if (id == user.getId()) {
                iterator.remove();
                return user;
            }
        }
         return null;
    }

}


