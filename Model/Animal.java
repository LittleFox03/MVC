package Model;

public class Animal {
    private String id;
    private String type;
    private int ageYears;
    private int ageMonths;
    private Integer udders;

    public Animal(String id, String type, int ageYears, int ageMonths, Integer udders) {
        this.id = id;
        this.type = type;
        this.ageYears = ageYears;
        this.ageMonths = ageMonths;
        this.udders = udders;
    }

    public String getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public int getAgeYears() {
        return ageYears;
    }

    public int getAgeMonths() {
        return ageMonths;
    }

    public Integer getUdders() {
        return udders;
    }

    public void setUdders(Integer udders) {
        this.udders = udders;
    }
}
