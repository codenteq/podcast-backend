package com.codenteq.podcast.services.series;

import com.codenteq.podcast.models.Series;

import java.util.List;
import java.util.UUID;

public interface SeriesService {
    public List<Series> list();
    public Series find(UUID id);
    public Series create(Series series);
    public Series update(UUID id, Series series);
    public void delete(UUID id);
}
