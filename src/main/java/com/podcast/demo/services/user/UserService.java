package com.podcast.demo.services.user;

import com.podcast.demo.models.User;

import java.util.List;
import java.util.UUID;

public interface UserService {
    List<User> list();
    User find(UUID id);
    User create(User user);
    User update(UUID id, User user);
    void delete(UUID id);
}
