package com.carandev.contactsapi.controller;

import com.carandev.contactsapi.entity.User;
import com.carandev.contactsapi.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class UserController {
  
  @Autowired
  private UserServices services;
  
  @GetMapping("/users")
  public ResponseEntity<List<User>> getAllUsers() {
    return ResponseEntity.ok(this.services.getUserList());
  }
  
  @GetMapping("/user/{id}")
  public ResponseEntity<User> getUserById(@PathVariable int id){
    return ResponseEntity.ok().body(this.services.getUserById(id));
  }
  
  @PostMapping("/user")
  public ResponseEntity<User> addUser(@RequestBody User user) {
    return ResponseEntity.ok(this.services.createUser(user));
  }
  
  @PostMapping("/users")
  public ResponseEntity<List<User>> addUsers(@RequestBody List<User> users) {
    return ResponseEntity.ok(this.services.createUserList(users));
  }
  
  @PutMapping("/user")
  public ResponseEntity<User> updateUser(@RequestBody User user) {
    return ResponseEntity.ok().body(this.services.updateUserById(user));
  }
  
  @DeleteMapping("/user/{id}")
  public HttpStatus deleteUser(@PathVariable int id) {
    this.services.deleteUserById(id);
    return HttpStatus.OK;
  }
}
