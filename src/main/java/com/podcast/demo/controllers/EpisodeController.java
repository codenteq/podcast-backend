package com.podcast.demo.controllers;


import com.podcast.demo.models.Episode;
import com.podcast.demo.services.episode.DefaultEpisodeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/episodes")
public class EpisodeController {
    private final DefaultEpisodeService episodeService;

    public EpisodeController(DefaultEpisodeService episodeService) {
        this.episodeService = episodeService;
    }


    @GetMapping
    public List<Episode> list() {
        return episodeService.list();
    }

    @GetMapping("/{id}")
    public Episode find(UUID id) {
        return episodeService.find(id);
    }

    @PostMapping
    public Episode create(@RequestBody Episode episode) {
        return episodeService.create(episode);
    }

    @PutMapping("/{id}")
    public Episode update(@PathVariable("id") UUID id, @RequestBody Episode episode) {
        return episodeService.update(id, episode);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") UUID id) {
        episodeService.delete(id);
    }
}
