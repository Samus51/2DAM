package uiux.swing.ejercicio02.screens;

import javax.swing.*;
import java.awt.*;
import com.toedter.calendar.JDateChooser;

/**
 * Clase que representa la ventana de alta de cliente en la aplicación de gestión de usuarios y productos.
 * Permite al usuario ingresar los datos de un nuevo cliente y agregarlos a la lista de clientes.
 */
public class AltaCliente extends JFrame {
    private static final long serialVersionUID = 1L;

    /** Campo de texto para el nombre del cliente */
    private JTextField nombreField;

    /** Campo de texto para los apellidos del cliente */
    private JTextField apellidosField;

    /** Selector de fecha para la fecha de nacimiento del cliente */
    private JDateChooser fechaNacimientoChooser;

    /** ComboBox para seleccionar la provincia del cliente */
    private JComboBox<String> provinciaComboBox;

    /** Botón para agregar el cliente */
    private JButton agregarButton;

    /**
     * Constructor de la clase AltaCliente.
     * Crea y configura la interfaz gráfica para el alta de un cliente.
     *
     * @param pantalla Referencia a la pantalla principal para poder agregar el cliente a la lista
     */
    public AltaCliente(PantallaInicial pantalla) {
        setTitle("Alta Cliente");
        setSize(400, 250);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(5, 2));

        add(new JLabel("Nombre:"));
        nombreField = new JTextField();
        add(nombreField);

        add(new JLabel("Apellidos:"));
        apellidosField = new JTextField();
        add(apellidosField);

        add(new JLabel("Fecha de Nacimiento:"));
        fechaNacimientoChooser = new JDateChooser();
        add(fechaNacimientoChooser);

        add(new JLabel("Provincia:"));
        provinciaComboBox = new JComboBox<>(new String[]{
                "Madrid", "Barcelona", "Valencia", "Sevilla", "Bilbao", "Zaragoza",
                "Málaga", "Murcia", "Palma", "Las Palmas", "Castellón", "Alicante",
                "Córdoba", "Granada", "Jaén", "Huelva", "Salamanca", "Toledo",
                "Santiago de Compostela", "Vigo", "Oviedo", "Gijón", "Logroño",
                "San Sebastián", "Pamplona", "Albacete", "Cádiz", "Burgos",
                "Lleida", "Tarragona", "Almería", "Huesca", "Cáceres", "Badajoz",
                "A Coruña", "Santa Cruz de Tenerife", "Ceuta", "Melilla"
        });
        add(provinciaComboBox);

        agregarButton = new JButton("Agregar Cliente");
        agregarButton.addActionListener(e -> {
            String nombre = nombreField.getText();
            String apellidos = apellidosField.getText();
            java.util.Date fechaNacimiento = fechaNacimientoChooser.getDate();

            // Validar campos vacíos
            if (nombre.isEmpty() || apellidos.isEmpty() || fechaNacimiento == null) {
                JOptionPane.showMessageDialog(this, "Todos los campos son obligatorios.", "Error",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }

            String cliente = nombre + " " + apellidos + ", " +
                    new java.text.SimpleDateFormat("dd/MM/yyyy").format(fechaNacimiento) + ", " +
                    provinciaComboBox.getSelectedItem();

            int confirm = JOptionPane.showConfirmDialog(this,
                    "¿Está seguro de que desea agregar el cliente " + cliente + "?", "Confirmar Agregar",
                    JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                pantalla.agregarCliente(cliente);
                dispose();
            }
        });
        add(new JLabel()); // Espacio en blanco
        add(agregarButton);

        setVisible(true);
    }
}
