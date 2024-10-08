package ad.swing;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.TextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PantallaInicial extends JFrame {
    private static final String SQL_SELECT_ALL = "SELECT film.film_id, film.title, film.release_year " +
            "FROM film ORDER BY film.film_id;";
    
    private static final String SQL_SELECT_ACTORS_BY_FILM_ID = "SELECT actor.actor_id, actor.first_name, actor.last_name " +
            "FROM actor " +
            "INNER JOIN film_actor ON film_actor.actor_id = actor.actor_id " +
            "INNER JOIN film ON film_actor.film_id = film.film_id " +
            "WHERE film.film_id = ?;";

    private static final long serialVersionUID = 1L;
    private JTextField txtIdFilm;
    private JPanel contentPane;
    private JTextField txtTitle;
    private JTextField txtRelease_year;
    private ResultSet rs;
    private final TextArea txtAreaActores = new TextArea();
    
    // Lista para almacenar las películas
    private List<Films> listaPelis;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                PantallaInicial frame = new PantallaInicial();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public PantallaInicial() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 540, 378);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);

        txtIdFilm = new JTextField();
        txtIdFilm.setEditable(false);
        txtIdFilm.setBounds(15, 16, 86, 20);
        txtIdFilm.setColumns(10);

        txtTitle = new JTextField();
        txtTitle.setEditable(false);
        txtTitle.setBounds(15, 47, 86, 20);
        txtTitle.setColumns(10);

        txtRelease_year = new JTextField();
        txtRelease_year.setEditable(false);
        txtRelease_year.setBounds(15, 73, 86, 20);
        txtRelease_year.setColumns(10);

        JLabel lblNewLabel = new JLabel("Id_film");
        lblNewLabel.setBounds(119, 19, 32, 14);
        JLabel lblTitle = new JLabel("Title");
        lblTitle.setBounds(119, 50, 20, 14);
        JLabel lblAo = new JLabel("year_release");
        lblAo.setBounds(119, 76, 63, 14);

        JButton btnPrimero = new JButton("Primero");
        btnPrimero.setBounds(394, 15, 69, 23);
        btnPrimero.addActionListener(e -> mostrarDatos("primero"));

        JButton btnUltimo = new JButton("Ultimo");
        btnUltimo.setBounds(394, 49, 69, 23);
        btnUltimo.addActionListener(e -> mostrarDatos("ultimo"));

        JButton btnSiguiente = new JButton("Siguiente");
        btnSiguiente.setBounds(394, 83, 69, 23);
        btnSiguiente.addActionListener(e -> mostrarDatos("siguiente"));

        JButton btnAnterior = new JButton("Anterior");
        btnAnterior.setBounds(392, 117, 71, 23);
        btnAnterior.addActionListener(e -> mostrarDatos("anterior"));
        
        JLabel lblActors = new JLabel("Actors");
        lblActors.setBounds(188, 142, 63, 14);
        contentPane.setLayout(null);
        contentPane.add(txtIdFilm);
        contentPane.add(lblNewLabel);
        contentPane.add(btnPrimero);
        contentPane.add(txtTitle);
        contentPane.add(txtRelease_year);
        contentPane.add(lblTitle);
        contentPane.add(lblAo);
        contentPane.add(btnUltimo);
        txtAreaActores.setEditable(false);
        txtAreaActores.setBounds(15, 104, 167, 100);
        contentPane.add(txtAreaActores);
        contentPane.add(lblActors);
        contentPane.add(btnAnterior);
        contentPane.add(btnSiguiente);
        
        JButton btnNueva = new JButton("Nueva");
        btnNueva.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                nuevaPelicula();
            }
        });
        btnNueva.setBounds(394, 168, 69, 23);
        contentPane.add(btnNueva);
        
        JButton btnGuardar = new JButton("Guardar");
        btnGuardar.setBounds(394, 210, 69, 23);
        contentPane.add(btnGuardar);
        
        // Inicializar la lista de películas
        listaPelis = new ArrayList<>();
        
        initializeResultSet();
    }

    protected void nuevaPelicula() {
        
    		txtTitle.setText("");
    		txtRelease_year.setText("");
    		txtAreaActores.setText("");
    		txtIdFilm.setText(String.valueOf(listaPelis.size() + 1));

    	
    		String title = txtTitle.getText();
        int id_film = Integer.parseInt(txtIdFilm.getText());
        int release_year = Integer.parseInt(txtRelease_year.getText());
        
        List<String> actores = new ArrayList<>();
        for (String actor : txtAreaActores.getText().split("\n")) {
            actores.add(actor.trim());
        }

        
        Films peliNueva = new Films(id_film, title, release_year, actores);
        
        listaPelis.add(peliNueva);
        
        System.out.println("Película añadida: " + peliNueva.toString());
    }

    private void initializeResultSet() {
        try {
            Connection conexion = Conector.conectar();
            PreparedStatement sentencia = conexion.prepareStatement(SQL_SELECT_ALL, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rs = sentencia.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void mostrarDatos(String accion) {
        try {
            switch (accion) {
                case "primero":
                    if (rs.first()) {
                        actualizarCampos();
                    }
                    break;
                case "ultimo":
                    if (rs.last()) {
                        actualizarCampos();
                    }
                    break;
                case "siguiente":
                    if (rs.next()) {
                        actualizarCampos();
                    }
                    break;
                case "anterior":
                    if (rs.previous()) {
                        actualizarCampos();
                    }
                    break;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void actualizarCampos() throws SQLException {
        txtIdFilm.setText(String.valueOf(rs.getInt("film_id")));
        txtRelease_year.setText(String.valueOf(rs.getInt("release_year")));
        txtTitle.setText(rs.getString("title"));
        
        // Mostrar todos los actores de la película actual
        mostrarAllActores(rs.getInt("film_id"));
    }

    private void mostrarAllActores(int filmId) {
        StringBuilder actores = new StringBuilder();
        try {
            Connection conexion = Conector.conectar();
            PreparedStatement sentencia = conexion.prepareStatement(SQL_SELECT_ACTORS_BY_FILM_ID);
            sentencia.setInt(1, filmId);
            ResultSet rsActores = sentencia.executeQuery();

            while (rsActores.next()) {
                String nombreActor = rsActores.getString("first_name") + " " + rsActores.getString("last_name");
                actores.append(nombreActor).append("\n");
            }
            txtAreaActores.setText(actores.toString());
            rsActores.close(); // Cierra el ResultSet de actores
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
