package com.capgemini.Airport.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller("airportcontroller")
@RequestMapping("/airport")
public class AirtportController {
    @RequestMapping("/")
    public String index(Map<String, Object> model) {
        model.put("title", "Airtports");
        return "data/airport/index";
    }
}
