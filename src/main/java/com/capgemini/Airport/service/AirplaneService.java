package com.capgemini.Airport.service;

import com.capgemini.Airport.model.Airplane;
import com.capgemini.Airport.repository.AirplaneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AirplaneService {
    @Autowired
    private AirplaneRepository repository;

    public int create(Airplane airplane) {
        Airplane created = repository.save(airplane);
        return created.getId();
    }

    public List<Airplane> all() {
        Iterable<Airplane> iterable = repository.findAll();
        List<Airplane> units = new ArrayList<>();
        iterable.forEach(units::add);
        return units;
    }

    public Airplane read(final int id) {
        Optional<Airplane> airplane = repository.findById(id);
        if (airplane.isPresent()) {
            return airplane.get();
        }

        return null;
    }

    public Airplane update(Airplane airplane) {
        return repository.save(airplane);
    }

    public void delete(final int id) {
        repository.deleteById(id);
    }
}
