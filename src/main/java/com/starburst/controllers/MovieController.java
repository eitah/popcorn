package com.starburst.controllers;

import com.starburst.entities.Movie;
import com.starburst.enums.Rating;
import com.starburst.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/movies") // /api/controller/ would get us to the controllers
public class MovieController {
    private MovieService service;

    @Autowired
    public void setService(MovieService service) {
        this.service = service;
    }

    @RequestMapping(path={"", "/"}, method = RequestMethod.GET)
    public Page<Movie> index(@RequestParam( name = "page", required = false, defaultValue = "0") int page ) {  //GET /api/studios?page=X
        return this.service.findAll(page);
    }


    @RequestMapping(path = {"/name/{name}"}, method = RequestMethod.GET)
    public Movie findByName(@PathVariable String name) {
        return this.service.findByName(name);
    }

    @RequestMapping(path= {"/rating/{rating}"}, method = RequestMethod.GET)
    public List<Movie> findByRating(@PathVariable Rating rating) {  //GET /api/movies/rating/PG
        return this.service.findByRatingOrderByReleasedDesc(rating);
    }

    @RequestMapping(path = {"/{id}"}, method = RequestMethod.GET)
    public Movie show(@PathVariable int id) {
        return this.service.findOne(id);
    }

    @RequestMapping(path = {"", "/"}, method = RequestMethod.POST)
    public Movie create(@RequestBody Movie studio) {
        return this.service.create(studio);
    }

    @RequestMapping(path = {"/{id}"}, method = RequestMethod.DELETE)
    public void destroy(@PathVariable int id) {
        this.service.destroy(id);
    }

//    !!! we are not doing update for movies as that will get tricky
//    @RequestMapping(path = {"/{id}"}, method = RequestMethod.PUT)
//    public Movie update(@PathVariable int id, @RequestBody Movie studio) {
//        return this.service.update(id, studio);
//    }
}
