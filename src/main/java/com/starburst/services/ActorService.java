package com.starburst.services;

import com.starburst.entities.Actor;
import com.starburst.entities.Movie;
import com.starburst.entities.Studio;
import com.starburst.repositories.IActorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

// this is the business layer. Needs @Service annotation

@Service
public class ActorService {
    private IActorRepository repository;

    @Autowired // JPA creates a class that implements the iActor repository, and autowires it to this class
    public void setRepository(IActorRepository repository) {
        this.repository = repository;
    }

    public Page<Actor> findAll(int page) {
        Integer itemsPerPage = 3;
        PageRequest pr = new PageRequest(page, itemsPerPage);
        return this.repository.findAll(pr);

    }

    public Page<Movie> findAllMoviesByActorId(int id, int page) {
        Integer itemsPerPage = 3;
        PageRequest pr = new PageRequest(page, itemsPerPage);
        return this.repository.findAllMoviesByActorId(id, pr);

    }


    public Page<Studio> findAllStudiosByActorId(int id, int page) {
        Integer itemsPerPage = 3;
        PageRequest pr = new PageRequest(page, itemsPerPage);
        return this.repository.findAllStudiosByActorId(id, pr);

    }

    public Actor findOne(int id) {
        return this.repository.findOne(id);
    }

    // service needs to be able to create a studio
    public Actor create(Actor a) {
        return this.repository.save(a);
    }

    public void destroy(int id) {
        this.repository.delete(id);
    }




}
