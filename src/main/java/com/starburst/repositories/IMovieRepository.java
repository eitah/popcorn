package com.starburst.repositories;

import com.starburst.entities.Movie;
import com.starburst.entities.Studio;
import com.starburst.enums.Rating;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface IMovieRepository extends PagingAndSortingRepository<Movie, Integer>{  // cannot use primitives (int)
    public Movie findByName(String name); // does a select * from movies where movie.name = name


    public List<Movie> findByRatingOrderByReleasedByDesc(Rating rating);
}

