package com.podcast.demo.controllers;

import com.podcast.demo.models.User;
import com.podcast.demo.services.user.DefaultUserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final DefaultUserService userService;

    public UserController(DefaultUserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> list() {
        return userService.list();
    }

    @GetMapping("/{id}")
    public User find(@PathVariable("id") UUID id){
        return userService.find(id);
    }

    @PostMapping
    public User create(@RequestBody User user) {
        return userService.create(user);
    }

    @PutMapping("/{id}")
    public User update(@PathVariable("id") UUID id, @RequestBody User user){
        System.out.println("User: " + user);
        return userService.update(id, user);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") UUID id){
        userService.delete(id);
    }
}
