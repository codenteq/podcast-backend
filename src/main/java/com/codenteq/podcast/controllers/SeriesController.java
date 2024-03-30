package com.codenteq.podcast.controllers;


import com.codenteq.podcast.models.Series;
import com.codenteq.podcast.services.series.DefaultSeriesService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/series")
public class SeriesController {
    private final DefaultSeriesService seriesService;

    public SeriesController(DefaultSeriesService seriesService) {
        this.seriesService = seriesService;
    }

    @GetMapping
    public List<Series> list() {
        return seriesService.list();
    }

    @GetMapping("/{id}")
    public Series find(UUID id) {
        return seriesService.find(id);
    }

    @PostMapping
    public Series create(@RequestBody Series series) {
        System.out.println("Data: " + series);
        return seriesService.create(series);
    }

    @PutMapping("/{id}")
    public Series update(@PathVariable("id") UUID id, @RequestBody Series series) {
        return seriesService.update(id, series);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") UUID id) {
        seriesService.delete(id);
    }
}
