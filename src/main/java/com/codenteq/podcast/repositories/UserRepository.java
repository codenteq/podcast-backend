package com.codenteq.podcast.repositories;

import com.codenteq.podcast.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
}
