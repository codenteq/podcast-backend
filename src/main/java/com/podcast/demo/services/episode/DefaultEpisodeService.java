package com.podcast.demo.services.episode;

import com.podcast.demo.models.Episode;
import com.podcast.demo.repositories.EpisodeRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class DefaultEpisodeService implements EpisodeService {

    private final EpisodeRepository episodeRepository;

    public DefaultEpisodeService(EpisodeRepository episodeRepository) {
        this.episodeRepository = episodeRepository;
    }

    @Override
    public List<Episode> list() {
        return episodeRepository.findAll();
    }

    @Override
    public Episode find(UUID id) {
        return episodeRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public Episode create(Episode Episode) {
        return episodeRepository.save(Episode);
    }

    @Override
    public Episode update(UUID id, Episode Episode) {
        Episode existingEpisode = episodeRepository.findById(id).orElseThrow(EntityNotFoundException::new);

        existingEpisode.setName(Episode.getName());
        existingEpisode.setDescription(Episode.getDescription());
        existingEpisode.setPicture(Episode.getPicture());
        existingEpisode.setVoice(Episode.getVoice());
        existingEpisode.setVisibility(Episode.getVisibility());
        existingEpisode.setPublishedAt(Episode.getPublishedAt());

        return episodeRepository.save(existingEpisode);
    }

    @Override
    public void delete(UUID id) {
        episodeRepository.deleteById(id);
    }
}
