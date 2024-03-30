package com.codenteq.podcast.services.user;

import com.codenteq.podcast.models.User;

import java.util.List;
import java.util.UUID;

public interface UserService {
    List<User> list();
    User find(UUID id);
    User create(User user);
    User update(UUID id, User user);
    void delete(UUID id);
}
