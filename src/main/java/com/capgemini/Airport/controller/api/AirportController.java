package com.capgemini.Airport.controller.api;

import com.capgemini.Airport.model.Airport;
import com.capgemini.Airport.service.AirportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("airport_api_controller")
@RequestMapping("/api/airport")
public class AirportController {
    @Autowired
    private AirportService service;

    @RequestMapping(value = "/", method = RequestMethod.GET, produces = "application/json")
    public List<Airport> get() {
        return service.all();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces= MediaType.APPLICATION_JSON_VALUE)
    public Airport getSingle(@PathVariable(name="id") int id) {
        return service.read(id);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST, produces=MediaType.APPLICATION_JSON_VALUE)
    public Airport add(@RequestBody Airport airport) {
        int id = service.create(airport);
        airport.setId(id);
        return airport;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public Airport update(@RequestBody Airport airport) {
        return service.update(airport);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public boolean delete(@PathVariable(name="id") int id) {
        service.delete(id);
        return true;
    }
}
