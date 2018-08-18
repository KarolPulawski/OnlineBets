package pl.coderslab.model;

public class Team {
    private String name;
    private String city;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Team() {
    }

    public Team(String name, String city) {
        this.name = name;
        this.city = city;
    }
}
