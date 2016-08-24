package com.starburst.repositories;

import com.starburst.entities.Movie;
import com.starburst.entities.Studio;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository; // can do CRUD plus paging and sorting.  Other interfaces can do just CRUD
import org.springframework.data.repository.query.Param;

public interface IStudioRepository extends PagingAndSortingRepository<Studio, Integer>{  // cannot use primitives (int)
    // JPQL JPA Query Language - queries the models.  The select from Movie (class),
    // In the Movie class, there is a method called "studio" where s.id is the same as the ":id" in the line below
    @Query("select m from Movie m join m.studio s where s.id = :id")
    public Page<Movie> findAllMoviesByStudioID(@Param("id") int id, Pageable pageable);  // the query returns movies because <Movie> is the generic

    // to write straight sql instead of using JPQL, use the @NativeQuery.  The drawback to using SQL is that paging and sorting can't be handled by JPA



}
