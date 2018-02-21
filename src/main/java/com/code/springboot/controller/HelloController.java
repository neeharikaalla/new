package com.code.springboot.controller;

import com.code.springboot.service.DistanceService;
import com.code.springboot.service.NewModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@Controller
public class HelloController {
    private DistanceService distanceService;

    public HelloController(DistanceService distanceService) {
        this.distanceService = distanceService;
    }

    @RequestMapping(value = "/")
    public ModelAndView home() {
        NewModel newModel = new NewModel();


        return new ModelAndView("welcome", "command", newModel);
    }


    @RequestMapping(value = "/distance/s", method = RequestMethod.GET)
    public ModelAndView de(@RequestParam(value = "origin", required = false) String origin,
                           @RequestParam(value = "destination", required = false) String destination, ModelMap model, HttpServletResponse response) {

        try {
            Map distanceMap = distanceService.getDistance(origin, destination);


            model.addAttribute("distance", distanceMap.get("distance").toString());
            model.addAttribute("time", distanceMap.get("duration"));
            model.addAttribute("origin", origin);
            model.addAttribute("destination", destination);

            return new ModelAndView("details", "command", model);
        } catch (Exception e) {
            return new ModelAndView("Error", "command", e);
        }

    }

    @RequestMapping("/weather")
    public ModelAndView wea(Model model, @RequestParam(value = "name", required = false) String name) {
        Map weatherMap = distanceService.getWeather(name);
        model.addAttribute("sunSet", weatherMap.get("sunSet"));

        model.addAttribute("sun_rise", weatherMap.get("sun_rise"));
        model.addAttribute("time", weatherMap.get("time"));
        model.addAttribute("timezone", weatherMap.get("timezone"));


        return new ModelAndView("moreWeather", "command", model);
    }
}
