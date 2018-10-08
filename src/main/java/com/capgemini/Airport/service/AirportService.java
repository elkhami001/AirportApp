package com.capgemini.Airport.service;

import com.capgemini.Airport.model.Airport;
import com.capgemini.Airport.repository.AirportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AirportService {
    @Autowired
    private AirportRepository repository;

    public int create(Airport airport) {
        Airport created = repository.save(airport);
        return created.getId();
    }

    public List<Airport> all() {
        Iterable<Airport> iterable = repository.findAll();
        List<Airport> units = new ArrayList<>();
        iterable.forEach(units::add);
        return units;
    }

    public Airport read(final int id) {
        Optional<Airport> airport = repository.findById(id);
        if (airport.isPresent()) {
            return airport.get();
        }

        return null;
    }

    public Airport update(Airport airport) {
        return repository.save(airport);
    }

    public void delete(final int id) {
        repository.deleteById(id);
    }

}
