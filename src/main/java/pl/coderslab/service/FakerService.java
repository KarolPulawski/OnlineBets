package pl.coderslab.service;

import com.github.javafaker.Address;
import com.github.javafaker.Faker;
import com.github.javafaker.Team;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class FakerService {

    private ArrayList<JSONObject> todayGames = new ArrayList<>();

    FakerService() throws JSONException{
        this.regenerate();
        this.generateTeam();
    }

    public ArrayList<JSONObject> getTodayGames() {
        return todayGames;
    }

    @Scheduled(fixedRate = 5000)
    public void regenerate() throws JSONException {
        Faker faker = new Faker();
        todayGames.clear();
        for (int i = 0; i < 10; i++) {
            JSONObject oJsonInner = new JSONObject();
            oJsonInner.put("firstTeam", faker.team().name());
            oJsonInner.put("firstPoints", faker.number().randomDigitNotZero());
            oJsonInner.put("secondTeam", faker.team().name());
            oJsonInner.put("secondPoints", faker.number().randomDigitNotZero());
            oJsonInner.put("sport", faker.team().sport());
            todayGames.add(oJsonInner);
        }
    }
    
    
    private ArrayList<JSONObject> teams = new ArrayList<>();
    private ArrayList<pl.coderslab.model.Team> teamsConsole = new ArrayList<>();

    public ArrayList<pl.coderslab.model.Team> getTeamsConsole() {
        return teamsConsole;
    }

    public ArrayList<JSONObject> getTeams() {
        return teams;
    }

    public void generateTeam() {
        Faker faker = new Faker();
        teams.clear();
        for(int i = 0; i < 20; i++) {
            JSONObject oJsonInner = new JSONObject();



            String t = faker.team().name();
            String c = faker.address().city();

            oJsonInner.put("name", t);
            oJsonInner.put("city", c);

            pl.coderslab.model.Team team = new pl.coderslab.model.Team();
            team.setName(t);
            team.setCity(c);

            teams.add(oJsonInner);
            teamsConsole.add(team);
        }
    }
}
