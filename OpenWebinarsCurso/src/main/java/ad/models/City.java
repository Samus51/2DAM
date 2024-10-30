package ad.models;

public class City {
    private int id;  // Agregar el ID
    private String name;
    private String countryCode;
    private String district;
    private int population;

    // Constructor
    public City(int id, String name, String countryCode, String district, int population) {
        this.id = id;  // Asignar el ID
        this.name = name;
        this.countryCode = countryCode;
        this.district = district;
        this.population = population;
    }

    // Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public String getDistrict() {
        return district;
    }

    public int getPopulation() {
        return population;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public void setPopulation(int population) {
        this.population = population;
    }
}
