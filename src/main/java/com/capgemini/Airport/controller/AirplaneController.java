package com.capgemini.Airport.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller("airplanecontroller")
@RequestMapping("/airplane")
public class AirplaneController {
    @RequestMapping("/")
    public String index(Map<String, Object> model) {
        model.put("title", "Airplanes");
        return "data/airplane/index";
    }
}
