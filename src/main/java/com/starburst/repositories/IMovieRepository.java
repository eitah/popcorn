package com.starburst.repositories;

import com.starburst.entities.Movie;
import com.starburst.entities.Studio;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface IMovieRepository extends PagingAndSortingRepository<Movie, Integer>{  // cannot use primitives (int)

}
