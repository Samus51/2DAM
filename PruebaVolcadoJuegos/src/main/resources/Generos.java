
public class Generos {

import jakarta.persistence.*;

@Entity
@Table(name = "generos")
public class Genero {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_genero")
	private int id;

	@Column(name = "nombre", nullable = false)
	private String name;

	// Getters y Setters
}

}
