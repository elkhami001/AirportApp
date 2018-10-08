package com.capgemini.Airport.controller.api;

import com.capgemini.Airport.model.Airplane;
import com.capgemini.Airport.service.AirplaneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("airplane_api_controller")
@RequestMapping("/api/airplane")
public class AirplaneController {
    @Autowired
    private AirplaneService service;

    @RequestMapping(value = "/", method = RequestMethod.GET, produces = "application/json")
    public List<Airplane> get() {
        return service.all();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces= MediaType.APPLICATION_JSON_VALUE)
    public Airplane getSingle(@PathVariable(name="id") int id) {
        return service.read(id);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST, produces=MediaType.APPLICATION_JSON_VALUE)
    public Airplane add(@RequestBody Airplane airplane) {
        int id = service.create(airplane);
        airplane.setId(id);
        return airplane;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public Airplane update(@RequestBody Airplane airplane) {
        return service.update(airplane);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public boolean delete(@PathVariable(name="id") int id) {
        service.delete(id);
        return true;
    }
}
