package utils.rawg;

import java.util.List;
import java.util.Objects;

public class Juego {
    private String name;             
    private String descripcion;      
    private String released;         
    private int idDesarrollador;     // Los id de dev, genero y plataforma debe  
    								// ser lo primero que se cargue de volcado
    private Genero genero;            
    private List<Plataforma> plataformas;        
    private boolean creadoPorUsuario; 
    private int idUsuario;           
    private int gameTime;
    
    public Juego(String name, String descripcion, String released, int idDesarrollador, Genero genero, List<Plataforma> plataformas, boolean creadoPorUsuario, int idUsuario, int gameTime) {
        this.name = name;
        this.descripcion = descripcion;
        this.released = released;
        this.idDesarrollador = idDesarrollador;
        this.genero = genero;
        this.creadoPorUsuario = creadoPorUsuario;
        this.idUsuario = idUsuario;
        this.gameTime = gameTime;
        this.plataformas = plataformas;
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

    public Genero getGenero() {
        return genero;
    }

    public void setIdGenero(Genero genero) {
        this.genero = genero;
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
	            ", Desarrollador ID: " + idDesarrollador + ", Género ID: " + genero.getId_genero() + 
	            ", Plataforma ID: " + plataformas.toString() + ", Creado por Usuario: " + creadoPorUsuario + 
	            ", Usuario ID: " + idUsuario + ", Tiempo de Juego: " + gameTime + " minutos]";
	}




	public Plataforma[] getPlataformas() {
		return plataformas;
	}




	public void setPlataformas(Plataforma[] plataformas) {
		this.plataformas = plataformas;
	}


}
