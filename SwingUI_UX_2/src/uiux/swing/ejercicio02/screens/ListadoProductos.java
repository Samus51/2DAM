package uiux.swing.ejercicio02.screens;

import javax.swing.*;
import java.awt.*;
import utils.Producto;

/**
 * Clase que representa la ventana para listar productos.
 * Muestra una lista de todos los productos disponibles en la aplicación.
 */
public class ListadoProductos extends JDialog {
    private static final long serialVersionUID = 1L;
    private JTextArea productosTextArea;
    private PantallaInicial pantalla;

    /**
     * Constructor de la clase ListarProductos.
     *
     * @param pantalla La instancia de PantallaInicial para acceder a la lista de productos.
     */
    public ListadoProductos(PantallaInicial pantalla) {
        this.pantalla = pantalla;
        setIconImage(new ImageIcon(getClass().getResource("/resources/iconoui.jpg")).getImage());
        setTitle("Lista de Productos");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Colores elegidos
        Color fondoDialogo = new Color(224, 255, 255); // Color suave para el fondo del diálogo
        Color fondoTextoArea = new Color(240, 248, 255); // Alice Blue para el área de texto
        Color textoColor = new Color(0, 0, 0); // Negro para el texto

        // Configuración del fondo del diálogo
        getContentPane().setBackground(fondoDialogo);

        // Configuración del área de texto
        productosTextArea = new JTextArea();
        productosTextArea.setEditable(false);
        productosTextArea.setBackground(fondoTextoArea);
        productosTextArea.setForeground(textoColor);
        productosTextArea.setFont(new Font("Arial", Font.PLAIN, 12)); // Fuente del área de texto
        productosTextArea.setBorder(BorderFactory.createLineBorder(Color.GRAY)); // Borde gris para el área de texto
        JScrollPane scrollPane = new JScrollPane(productosTextArea);
        add(scrollPane, BorderLayout.CENTER);

        // Mostrar los productos en el área de texto
        actualizarProductosTextArea();

        setModal(true); // Hacer el diálogo modal
        setVisible(true);
    }

    /**
     * Actualiza el área de texto que muestra la lista de productos.
     */
    private void actualizarProductosTextArea() {
        productosTextArea.setText("");
        for (Producto producto : pantalla.getProductos()) {
            productosTextArea.append(producto + "\n");
        }
    }
}
