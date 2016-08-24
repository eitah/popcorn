package com.starburst.controllers;

import com.starburst.entities.Actor;
import com.starburst.entities.Movie;
import com.starburst.entities.Studio;
import com.starburst.services.ActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/actors") // /api/controller/ would get us to the controllers
public class ActorController {
    private ActorService service;

    @Autowired
    public void setService(ActorService service) {
        this.service = service;
    }

    @RequestMapping(path={"", "/"}, method = RequestMethod.GET)
    public Page<Actor> index(@RequestParam( name = "page", required = false, defaultValue = "0") int page ) {  //GET /api/actors?page=X
        return this.service.findAll(page);
    }

    @RequestMapping(path={"/{id}/movies"}, method = RequestMethod.GET)  //
    public Page<Movie> movies(@PathVariable int id, @RequestParam(name = "page", required = false, defaultValue = "0") int page) {
        return this.service.findAllMoviesByActorId(id, page);
    }

    @RequestMapping(path={"/{id}/studios"}, method = RequestMethod.GET)  //
    public Page<Studio> studios(@PathVariable int id, @RequestParam(name = "page", required = false, defaultValue = "0") int page) {
        return this.service.findAllStudiosByActorId(id, page);
    }

    @RequestMapping(path = {"/{id}"}, method = RequestMethod.GET)
    public Actor show(@PathVariable int id) {
        return this.service.findOne(id);
    }

    @RequestMapping(path = {"", "/"}, method = RequestMethod.POST)
    public Actor create(@RequestBody Actor actor) {
        return this.service.create(actor);
    }

    @RequestMapping(path = {"/{id}"}, method = RequestMethod.DELETE)
    public void destroy(@PathVariable int id) {
        this.service.destroy(id);
    }

//    !!! we are not doing update for actors as that will get tricky
//    @RequestMapping(path = {"/{id}"}, method = RequestMethod.PUT)
//    public Actor update(@PathVariable int id, @RequestBody Actor studio) {
//        return this.service.update(id, studio);
//    }
}
