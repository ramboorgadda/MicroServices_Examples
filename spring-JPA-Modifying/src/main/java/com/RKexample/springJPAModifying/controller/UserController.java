package com.RKexample.springJPAModifying.controller;

import com.RKexample.springJPAModifying.entity.Users;
import com.RKexample.springJPAModifying.repository.UserRepository;
import com.RKexample.springJPAModifying.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;
    @GetMapping
    public List<Users> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public Optional<Users> getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @PostMapping("/create")
    public Users createUser(@RequestBody Users user) {
        return userService.createUser(user);
    }

    @PutMapping("/{id}/email")
    public int updateUserEmail(@PathVariable Long id, @RequestParam String email) {
        return userService.updateUserEmail(id, email);
    }

    @DeleteMapping("/older-than/{age}")
    public int deleteUserOlderThan(@PathVariable int age) {
        return userService.deleteUserOlderThan(age);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }
}
