package com.starburst.services;

import com.starburst.entities.Movie;
import com.starburst.repositories.IMovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

// this is the business layer. Needs @Service annotation

@Service
public class MovieService {
    private IMovieRepository repository;

    @Autowired // JPA creates a class that implements the iMovie repository, and autowires it to this class
    public void setRepository(IMovieRepository repository) {
        this.repository = repository;
    }

    public Page<Movie> findAll(int page) {
        Integer itemsPerPage = 3;
        PageRequest pr = new PageRequest(page, itemsPerPage);
        return this.repository.findAll(pr);

    }


    public Movie findOne(int id) {
        return this.repository.findOne(id);
    }

    // service needs to be able to create a studio
    public Movie create(Movie m) {
        return this.repository.save(m);
    }

    public void destroy(int id) {
        this.repository.delete(id);
    }




}
