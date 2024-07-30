package net.java.springboot_backend.controller;

import net.java.springboot_backend.exception.resourceNotFound;
import net.java.springboot_backend.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/p1/user") //to put common base url for this rest api
public class userController {

    @Autowired
    private net.java.springboot_backend.repository.userRepository userRepository; //declare repository

    @GetMapping
    public List<User> getAllUser(){
        return userRepository.findAll();// get info from database
    }

    //create user REST API
    @PostMapping //no need to add URL because user already have in base url
    public User createUser(@RequestBody User us){
        return userRepository.save(us);
    }

    //build get user by id REST API
    @GetMapping("{id}")
    public ResponseEntity<User> getUserId(@PathVariable long id){ //path variable is to bind the id in url with method args
        User us=userRepository.findById(id).
                orElseThrow(()->new resourceNotFound("User does not exist with id: " + id));
        return ResponseEntity.ok(us);
    }

    //build update REST API
    @PutMapping("{id}")
    public ResponseEntity<User> updateUser(@PathVariable long id, @RequestBody User updateDetails){
        User updateUser=userRepository.findById(id).
                orElseThrow(()->new resourceNotFound("User does not exist with id: " + id));

        updateUser.setFirstname(updateDetails.getFirstname());
        updateUser.setLastname(updateDetails.getLastname());
        updateUser.setEmail(updateDetails.getEmail());

        userRepository.save(updateUser);

        return ResponseEntity.ok(updateUser);
    }

    //build delete REST Api
    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> deleteUser(@PathVariable long id){

        User delUser=userRepository.findById(id).
                     orElseThrow(()->new resourceNotFound("User does not exist with id: " + id));

        //delete data from database
        userRepository.delete(delUser);

        //not returning anything to client
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }

}
