/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.in28minutes.rest.webservices.restfulwebservices;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author 0011539
 */
//Controller
@RestController
public class HelloWorlController {
    
    /**
     *
     * helloWorld
     */
    @GetMapping( path="/hello-world")
    public String helloWorld() {
        return "Hello World";
    }
    
    /**
     *
     * helloWorldBean
     */
    @GetMapping( path="/hello-world-bean")
    public HelloWorldBean helloWorldBean() {
        return new HelloWorldBean("Hello World Bean");
    }
     
    /**
     *
     * helloWorldBeanPathVarable
     */
    @GetMapping( path="/hello-world-bean-path-variable/{name}")
    public HelloWorldBean helloWorldBeanPathVarable(@PathVariable String name) {
        return new HelloWorldBean(String.format("Hello World Bean, %s",name));
    }
    
}
