package com.podcast.demo.services.series;

import com.podcast.demo.enums.Language;
import com.podcast.demo.models.Series;
import com.podcast.demo.models.User;
import com.podcast.demo.repositories.SeriesRepository;
import com.podcast.demo.services.user.UserService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class DefaultSeriesService implements SeriesService {

    private final SeriesRepository seriesRepository;
    private final UserService userService;

    public DefaultSeriesService(SeriesRepository seriesRepository, UserService userService) {
        this.seriesRepository = seriesRepository;
        this.userService = userService;
    }

    @Override
    public List<Series> list() {
        return seriesRepository.findAll();
    }

    @Override
    public Series find(UUID id) {
        return seriesRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public Series create(Series series) {
/*        User user = userService.find(series.getUser().getId());
        series.setUser(user);*/
        return seriesRepository.save(series);
    }

    @Override
    public Series update(UUID id, Series series) {
        Series existingSeries = seriesRepository.findById(id).orElseThrow(EntityNotFoundException::new);

        existingSeries.setName(series.getName());
        existingSeries.setDescription(series.getDescription());
        existingSeries.setSlug(series.getSlug());
        existingSeries.setPicture(series.getPicture());
        existingSeries.setLanguage(Language.valueOf(series.getLanguage().name()));
        existingSeries.setCategory(series.getCategory());
        existingSeries.setUser(series.getUser());
        existingSeries.setVisibility(series.getVisibility());

        return seriesRepository.save(existingSeries);
    }

    @Override
    public void delete(UUID id) {
        seriesRepository.deleteById(id);
    }
}
