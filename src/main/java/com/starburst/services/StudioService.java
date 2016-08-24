package com.starburst.services;

import com.starburst.entities.Movie;
import com.starburst.entities.Studio;
import com.starburst.repositories.IStudioRepository;
import org.omg.CosNaming.IstringHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

// this is the business layer. Needs @Service annotation

@Service
public class StudioService {
    private IStudioRepository repository;

    @Autowired // JPA creates a class that implements the IStudio repository, and autowires it to this class
    public void setRepository(IStudioRepository repository) {
        this.repository = repository;
    }

    public Page<Studio> findAll(int page) {
        Integer itemsPerPage = 3;
        PageRequest pr = new PageRequest(page, itemsPerPage);
        return this.repository.findAll(pr);

    }

    public Page<Movie> findAllMoviesByStudioId(int id, int page) {
        Integer itemsPerPage = 3;
        PageRequest pr = new PageRequest(page, itemsPerPage);
        return this.repository.findAllMoviesByStudioID(id, pr);

    }

    public Studio findOne(int id) {
        return this.repository.findOne(id);
    }

    // service needs to be able to create a studio
    public Studio create(Studio s) {
        return this.repository.save(s);
    }

    public void destroy(int id) {
        this.repository.delete(id);
    }

    public Studio update(int id, Studio s) {
        Studio studio = this.repository.findOne(id);
        studio.setName(s.getName());
        studio.setEst(s.getEst());
        return this.repository.save(studio);
    }



}
