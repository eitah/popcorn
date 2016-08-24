package com.starburst.repositories;

import com.starburst.entities.Actor;
import com.starburst.entities.Movie;
import com.starburst.entities.Studio;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

public interface IActorRepository extends PagingAndSortingRepository<Actor, Integer>{  // cannot use primitives (int)

    @Query("select distinct m from Movie m join m.actors a where a.id = :id")
    public Page<Movie> findAllMoviesByActorId(@Param("id") int id, Pageable pageable);  // the query returns movies because <Movie> is the generic

    @Query("select distinct s from Movie m join m.actors a join m.studio s where a.id = :id")
    public Page<Studio> findAllStudiosByActorId(@Param("id") int id, Pageable pageable);  // the query returns movies because <Movie> is the generic
}
