package ad.swing;

import java.util.ArrayList;
import java.util.List;

public class Films {
    private int id_film;
    private String title;
    private int release_year;
    private List<String> actores; // Lista para almacenar los actores

    // Constructor
    public Films(int id_film, String title, int release_year, List<String> actores) {
        this.id_film = id_film;
        this.title = title;
        this.release_year = release_year;
        this.actores = actores != null ? actores : new ArrayList<>(); // Evita NullPointerException
    }

    // Getters y Setters
    public int getId_film() {
        return id_film;
    }

    public void setId_film(int id_film) {
        this.id_film = id_film;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getRelease_year() {
        return release_year;
    }

    public void setRelease_year(int release_year) {
        this.release_year = release_year;
    }

    public List<String> getActores() {
        return actores;
    }

    public void setActores(List<String> actores) {
        this.actores = actores;
    }
    
    // Método para agregar un actor
    public void agregarActor(String actor) {
        this.actores.add(actor);
    }

    // Método para obtener una representación en String de la película
    @Override
    public String toString() {
        return "Film ID: " + id_film + ", Title: " + title + ", Release Year: " + release_year + ", Actores: " + actores.toString();
    }
}
