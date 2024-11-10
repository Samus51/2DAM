package rawg.functions;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "juegos")

public class Juegos {

	@Id
	@Column(name = "id_juego")
	private int id;

	@Column(name = "titulo", nullable = false)
	private String name;

	@Column(name = "descripcion")
	private String description;

	@Column(name = "fecha_lanzamiento")
	private Date released;

	@Column(name = "precio")
	private double price;

	@Column(name = "creado_por_usuario", nullable = false)
	private boolean createdByUser = false;

	// Getters y Setters
}
