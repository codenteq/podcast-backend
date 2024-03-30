package com.codenteq.podcast.services.episode;

import com.codenteq.podcast.models.Episode;

import java.util.List;
import java.util.UUID;

public interface EpisodeService {
    public List<Episode> list();
    public Episode find(UUID id);
    public Episode create(Episode Episode);
    public Episode update(UUID id, Episode Episode);
    public void delete(UUID id);
}
