package utils.rawg;

import java.util.Objects;

public class Juego {
    private String name;             
    private String descripcion;      
    private String released;         
    private int idDesarrollador;     // Los id de dev, genero y plataforma debe  
    								// ser lo primero que se cargue de volcado
    private int idGenero;            
    private int idPlataforma;        
    private boolean creadoPorUsuario; 
    private int idUsuario;           
    private int gameTime;
    
    public Juego(String name, String descripcion, String released, int idDesarrollador, int idGenero, int idPlataforma, boolean creadoPorUsuario, int idUsuario, int gameTime) {
        this.name = name;
        this.descripcion = descripcion;
        this.released = released;
        this.idDesarrollador = idDesarrollador;
        this.idGenero = idGenero;
        this.idPlataforma = idPlataforma;
        this.creadoPorUsuario = creadoPorUsuario;
        this.idUsuario = idUsuario;
        this.gameTime = gameTime;
    }

    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getReleased() {
        return released;
    }

    public void setReleased(String released) {
        this.released = released;
    }

    public int getIdDesarrollador() {
        return idDesarrollador;
    }

    public void setIdDesarrollador(int idDesarrollador) {
        this.idDesarrollador = idDesarrollador;
    }

    public int getIdGenero() {
        return idGenero;
    }

    public void setIdGenero(int idGenero) {
        this.idGenero = idGenero;
    }

    public int getIdPlataforma() {
        return idPlataforma;
    }

    public void setIdPlataforma(int idPlataforma) {
        this.idPlataforma = idPlataforma;
    }

    public boolean isCreadoPorUsuario() {
        return creadoPorUsuario;
    }

    public void setCreadoPorUsuario(boolean creadoPorUsuario) {
        this.creadoPorUsuario = creadoPorUsuario;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    // Método equals() para comparar si los juegos son iguales (importante para evitar duplicados)
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Juego juego = (Juego) obj;
        return name.equals(juego.name); 
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }


	public int getGameTime() {
		return gameTime;
	}


	public void setGameTime(int gameTime) {
		this.gameTime = gameTime;
	}

	@Override
	public String toString() {
	    return "Juego: [Nombre: " + name + ", Descripción: " + descripcion + ", Lanzamiento: " + released +
	            ", Desarrollador ID: " + idDesarrollador + ", Género ID: " + idGenero + 
	            ", Plataforma ID: " + idPlataforma + ", Creado por Usuario: " + creadoPorUsuario + 
	            ", Usuario ID: " + idUsuario + ", Tiempo de Juego: " + gameTime + " minutos]";
	}


}
