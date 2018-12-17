/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.in28minutes.rest.webservices.restfulwebservices;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *
 * @author 0011539
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
class UserExcpetionNotFound extends RuntimeException {

    
    public UserExcpetionNotFound(String message) {
        super(message);
    }
    
}
