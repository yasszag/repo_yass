/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.in28minutes.rest.webservices.restfulwebservices;

import java.net.URI;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

/**
 *
 * @author 0011539
 */
@RestController
public class UserResource {
    @Autowired
    private UserDaoService service;
    //GET /users
    //User retrieveAllUsers
    @GetMapping(path = "/users")
    public List<User> retrieveAllUsers (){
        return service.FindAll();
    }
    
    //GET /users/{id}
    //User retrieveUser(int id)
    
/*    public Resource<User> retrieveUser(@PathVariable int id){
       User user = service.FindOne(id);
       
        if (user == null) {
            throw new UserExcpetionNotFound("id-" + id);
        }
       Resource<User> resource = new Resource<User>(user);
        ControllerLinkBuilder linkTo = ControllerLinkBuilder.linkTo(ControllerLinkBuilder.methodOn(this.getClass()).retrieveAllUsers());
        resource.add(linkTo.withRel("all-users"));
        
        return resource;
    }
*/

    @GetMapping(path = "/users/{id}")
    public User retrieveUser(@PathVariable int id){
        User user = service.FindOne(id);
        if (user == null)
            throw new UserExcpetionNotFound("id - " + id);
        return user;
    }
    
    // Create user
    @PostMapping(path = "/users")
    public ResponseEntity<Object> createUser(@Valid @RequestBody User user){
       User savedUser;
       savedUser = service.SaveUser(user);
        //Con esta sentencia obtengo el identificador del usuario que he creado
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId()).toUri();   
        return ResponseEntity.created(location).build();
    }
    
     // Deelete user
    @DeleteMapping(path = "/users/{id}")
    public void deleteUser(@PathVariable int id){
       User deletedUser;
       deletedUser = service.DeketeById(id);
        if (deletedUser == null) {
            throw new UserExcpetionNotFound("id-" + id);
        }        
    }
    
}