package uiux.swing.ejercicio02.screens;

import javax.swing.*;
import com.toedter.calendar.JDateChooser;
import java.awt.*;
import java.text.SimpleDateFormat;

/**
 * Clase que representa la ventana de alta de cliente en la aplicación de
 * gestión de usuarios y productos. Permite al usuario ingresar los datos de un
 * nuevo cliente y agregarlos a la lista de clientes.
 */
public class AltaCliente extends JDialog {
    private static final long serialVersionUID = 1L;

    protected JTextField nombreField;
    protected JTextField apellidosField;
    private JDateChooser fechaNacimientoChooser;
    private JComboBox<String> provinciaComboBox;
    private JButton agregarButton;

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
        provinciaComboBox = new JComboBox<>(new String[] { "Madrid", "Barcelona", "Valencia", "Sevilla", "Bilbao",
                "Zaragoza", "Málaga", "Murcia", "Palma", "Las Palmas", "Castellón", "Alicante", "Córdoba", "Granada", "Jaén",
                "Huelva", "Salamanca", "Toledo", "Santiago de Compostela", "Vigo", "Oviedo", "Gijón", "Logroño",
                "San Sebastián", "Pamplona", "Albacete", "Cádiz", "Burgos", "Lleida", "Tarragona", "Almería", "Huesca",
                "Cáceres", "Badajoz", "A Coruña", "Santa Cruz de Tenerife", "Ceuta", "Melilla" });
        add(provinciaComboBox);

        agregarButton = new JButton("Agregar Cliente");
        agregarButton.addActionListener(e -> {
            String nombre = nombreField.getText().trim();
            String apellidos = apellidosField.getText().trim();
            java.util.Date fechaNacimiento = fechaNacimientoChooser.getDate();
            String provincia = (String) provinciaComboBox.getSelectedItem();

            // Validar campos vacíos
            if (nombre.isEmpty() || apellidos.isEmpty() || fechaNacimiento == null || provincia == null) {
                JOptionPane.showMessageDialog(this, "Todos los campos son obligatorios.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Formatear fecha
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            String fechaNacimientoFormateada = dateFormat.format(fechaNacimiento);

            // Crear un cliente en una sola línea en el formato requerido
            String clienteInfo = String.format("Nombre: %s, Apellidos: %s, Fecha de Nacimiento: %s, Provincia: %s", 
                nombre, apellidos, fechaNacimientoFormateada, provincia);

            // Comprobar si ya existe un cliente con el mismo nombre (ignorando mayúsculas y minúsculas)
            if (pantalla.getClientes().stream().map(String::toLowerCase).anyMatch(clienteInfo.toLowerCase()::equals)) {
                JOptionPane.showMessageDialog(this, "No puede introducir un cliente ya creado.", "Error",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Agregar cliente
            pantalla.agregarCliente(clienteInfo);
            dispose();
        });

        add(new JLabel());
        add(agregarButton);

        setModal(true); // Hacer el diálogo modal
        setVisible(true);
    }
}
