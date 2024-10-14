package uiux.swing.ejercicio02.screens;

import javax.swing.*;
import java.awt.*;

public class AltaProducto extends JFrame {
    private static final long serialVersionUID = 1L;
    private JTextField nombreField, precioField;
    private JCheckBox perecederoCheckBox;
    private JButton agregarButton;
    private PantallaInicial pantalla;

    public AltaProducto(PantallaInicial pantalla) {
        this.pantalla = pantalla;
        setTitle("Alta Producto");
        setSize(400, 200);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(4, 2));

        add(new JLabel("Nombre:"));
        nombreField = new JTextField();
        add(nombreField);

        add(new JLabel("Precio Unitario:"));
        precioField = new JTextField();
        add(precioField);

        add(new JLabel("Perecedero:"));
        perecederoCheckBox = new JCheckBox();
        add(perecederoCheckBox);

        agregarButton = new JButton("Agregar Producto");
        agregarButton.addActionListener(e -> {
            String nombre = nombreField.getText();
            double precio;
            try {
                precio = Double.parseDouble(precioField.getText());
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "El precio debe ser un número válido.", "Error",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Validar campos vacíos y precio no negativo
            if (nombre.isEmpty() || precio <= 0) {
                JOptionPane.showMessageDialog(this, "Todos los campos son obligatorios.", "Error",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }

            String producto = nombre + ", " + precio + "€, " + (perecederoCheckBox.isSelected() ? "Perecedero" : "No Perecedero");
            int confirm = JOptionPane.showConfirmDialog(this,
                    "¿Está seguro de que desea agregar el producto " + producto + "?", "Confirmar Agregar",
                    JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                pantalla.getProductos().add(producto);
                dispose();
            }
        });

        add(new JLabel()); // Espacio en blanco
        add(agregarButton);

        setVisible(true);
    }
}
