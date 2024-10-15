package uiux.swing.ejercicio02.screens;

import javax.swing.*;
import com.toedter.calendar.JDateChooser;
import java.awt.*;
import java.text.SimpleDateFormat;

/**
 * Clase que representa la ventana de alta de cliente en la aplicación de gestión de usuarios y productos.
 * Permite al usuario ingresar los datos de un nuevo cliente y agregarlos a la lista de clientes.
 */
public class AltaCliente extends JDialog {
    private static final long serialVersionUID = 1L;

    protected JTextField nombreField;
    protected JTextField apellidosField;
    private JDateChooser fechaNacimientoChooser;
    private JComboBox<String> provinciaComboBox;
    private JButton agregarButton;

    /**
     * Constructor de la clase AltaCliente.
     * 
     * @param pantalla Referencia a la pantalla principal para poder agregar el cliente a la lista.
     */
    public AltaCliente(PantallaInicial pantalla) {
        setIconImage(new ImageIcon(getClass().getResource("/resources/iconoui.jpg")).getImage());
    	setTitle("Alta Cliente");
        setSize(400, 250);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(5, 2));
        
        // Colores elegidos
        Color fondoDialogo = new Color(224, 255, 255); // Color suave para el fondo del diálogo
        Color textoColor = new Color(0, 0, 0); // Negro para el texto
        Color labelColor = new Color(0, 102, 204); // Azul oscuro para las etiquetas
        Color buttonColor = new Color(70, 130, 180); // Steel Blue para el botón

        // Configuración del fondo del diálogo
        getContentPane().setBackground(fondoDialogo);

        // Añadir etiquetas y campos
        JLabel nombreLabel = new JLabel("Nombre:");
        nombreLabel.setForeground(labelColor);
        add(nombreLabel);
        nombreField = new JTextField();
        add(nombreField);

        JLabel apellidosLabel = new JLabel("Apellidos:");
        apellidosLabel.setForeground(labelColor);
        add(apellidosLabel);
        apellidosField = new JTextField();
        add(apellidosField);

        JLabel fechaNacimientoLabel = new JLabel("Fecha de Nacimiento:");
        fechaNacimientoLabel.setForeground(labelColor);
        add(fechaNacimientoLabel);
        fechaNacimientoChooser = new JDateChooser();
        add(fechaNacimientoChooser);

        JLabel provinciaLabel = new JLabel("Provincia:");
        provinciaLabel.setForeground(labelColor);
        add(provinciaLabel);
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

        // Botón para agregar cliente
        agregarButton = new JButton("Agregar Cliente");
        agregarButton.setBackground(buttonColor);
        agregarButton.setForeground(Color.WHITE); // Texto en blanco
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

            // Crear cliente
            String clienteInfo = String.format("Nombre: %s, Apellidos: %s, Fecha de Nacimiento: %s, Provincia: %s", 
                nombre, apellidos, fechaNacimientoFormateada, provincia);

            // Comprobar duplicado
            if (pantalla.getClientes().stream().map(String::toLowerCase).anyMatch(clienteInfo.toLowerCase()::equals)) {
                JOptionPane.showMessageDialog(this, "No puede introducir un cliente ya creado.", "Error",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Agregar cliente
            pantalla.agregarCliente(clienteInfo);
            dispose();
        });

        add(new JLabel()); // Espacio en blanco
        add(agregarButton);

        setModal(true); // Hacer el diálogo modal
        setVisible(true);
    }
}
