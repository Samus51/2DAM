package uiux.swing.ejercicio02.screens;

import javax.swing.*;
<<<<<<< HEAD

import utils.Producto;

import java.awt.*;

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
        setTitle("Lista de Productos");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        productosTextArea = new JTextArea();
        productosTextArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(productosTextArea);
        add(scrollPane, BorderLayout.CENTER);

        // Mostrar los productos en el área de texto
        actualizarProductosTextArea();

=======
import java.awt.*;

/**
 * Clase que representa la ventana para listar productos.
 * Muestra una lista de todos los productos disponibles en la aplicación.
 */
public class ListadoProductos extends JFrame {
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
        setTitle("Lista de Productos");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        productosTextArea = new JTextArea();
        productosTextArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(productosTextArea);
        add(scrollPane, BorderLayout.CENTER);

        // Mostrar los productos en el área de texto
        actualizarProductosTextArea();

>>>>>>> d7bf18b3bf8bd8f10fbc24ebdf3e0e1e78507536
        setVisible(true);
    }

    /**
     * Actualiza el área de texto que muestra la lista de productos.
     */
    private void actualizarProductosTextArea() {
        productosTextArea.setText("");
<<<<<<< HEAD
        for (Producto producto : pantalla.getProductos()) {
=======
        for (String producto : pantalla.getProductos()) {
>>>>>>> d7bf18b3bf8bd8f10fbc24ebdf3e0e1e78507536
            productosTextArea.append(producto + "\n");
        }
    }
}
