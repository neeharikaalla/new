package com.code.springboot.controller

import com.code.springboot.service.DistanceService
import com.code.springboot.service.NewModel
import org.json.simple.parser.ParseException
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.ui.ModelMap
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.servlet.ModelAndView

import javax.servlet.http.HttpServletResponse

/**
 * Main controller for all user interactions
 */
@Controller
public class HelloController {
    private DistanceService distanceService;
    private final Logger log = LoggerFactory.getLogger(this.getClass());

    public HelloController(DistanceService distanceService) {
        this.distanceService = distanceService;
    }

    /**
     * Default get method returns new welcome page
     * @return welcome.jsp
     */
    @RequestMapping()
    public ModelAndView home() {
        log.info("reached default get returning welcome ");
        NewModel newModel = new NewModel();
        return new ModelAndView("welcome", "command", newModel);
    }

    /**
     * Second view returns distance from A-b with other options like weather...
     * @param origin
     * @param destination
     * @param model
     * @param response
     * @return details
     */
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
    public ModelAndView wea(Model model,
                            @RequestParam(value = "name", required = false) String name, HttpServletResponse response) throws ParseException, IOException {
        response.addHeader("Access-Control-Allow-Origin", "*")
        model.addAttribute("destination", name)
        return new ModelAndView("moreWeather", "command", model);
    }


    @RequestMapping("/weather/api")
    public ResponseEntity<Map<Object, Object>> weat(@RequestParam(value = "name", required = false) String name) throws ParseException, IOException {

        return new ResponseEntity<Map<Object, Object>>(distanceService.getWeather(name), HttpStatus.OK)
    }

    @RequestMapping("/9flags/api")
    public ResponseEntity<Map<Object, Object>> get9FlatsApi(@RequestParam(value = "name", required = false) String name) throws ParseException, IOException {

        return new ResponseEntity<Map<Object, Object>>(distanceService.get9FlatsApi(name), HttpStatus.OK)
    }

    @RequestMapping("/9flags")
    public ModelAndView flags(Model model,
                            @RequestParam(value = "name", required = false) String name, HttpServletResponse response) throws ParseException, IOException {
        response.addHeader("Access-Control-Allow-Origin", "*")
        model.addAttribute("destination", name)
        return new ModelAndView("9flags", "command", model)
    }
}
