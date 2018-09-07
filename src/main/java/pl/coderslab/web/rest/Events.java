package pl.coderslab.web.rest;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.service.FakerService;

import java.util.ArrayList;

@RestController
@RequestMapping("/api")
public class Events {

    @Autowired
    private FakerService fakerService;

    @GetMapping(path= "/fake-today-games")
    public String sample() {
        return fakerService.getTodayGames().toString();
    }

    @RequestMapping(path = "/fake-team", method = RequestMethod.GET)
    public String getTeam() {
        fakerService.getTeamsConsole().forEach(s -> {
            System.out.print(s.getName());
            System.out.print(" | ");
            System.out.print(s.getCity());
            System.out.println();});
        return fakerService.getTeams().toString();
    }
}
