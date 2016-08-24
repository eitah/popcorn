package com.starburst.repositories;

import com.starburst.entities.Actor;
import com.starburst.entities.Movie;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface IActorRepository extends PagingAndSortingRepository<Actor, Integer>{  // cannot use primitives (int)

}
