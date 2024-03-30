package com.codenteq.podcast.repositories;

import com.codenteq.podcast.models.Episode;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface EpisodeRepository extends JpaRepository<Episode, UUID> {
}
