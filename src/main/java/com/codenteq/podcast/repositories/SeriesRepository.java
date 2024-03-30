package com.codenteq.podcast.repositories;

import com.codenteq.podcast.models.Series;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SeriesRepository extends JpaRepository<Series, UUID> {
}
