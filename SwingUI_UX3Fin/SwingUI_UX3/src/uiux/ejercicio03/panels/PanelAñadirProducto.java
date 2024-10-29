package uiux.ejercicio03.panels;

import javax.swing.*;
import java.awt.*;
import net.miginfocom.swing.MigLayout;
import uiuc.models.Producto;
import uiux.ejercicio03.VentanaPrincipal;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PanelAñadirProducto extends JPanel {
    private static final long serialVersionUID = 1L;
    private JTextField txtNombreProducto;
    private JTextField txtPrecio;
    private JRadioButton radioButtonPerecedero;

    public PanelAñadirProducto() {
        setBackground(new Color(176, 224, 230));
        setLayout(new MigLayout("", "[][][][][][][][154px][][][][][][grow][][][][][][][][][]",
                "[24px][][][][][][][][][]"));
        
        JLabel label = new JLabel("Añadir Producto");
        label.setFont(new Font("Arial", Font.BOLD, 20));
        label.setForeground(Color.DARK_GRAY); // Cambiar color de texto a gris oscuro
        add(label, "cell 6 0,alignx center,aligny center");

        JLabel lblNewLabel = new JLabel("Nombre");
        lblNewLabel.setForeground(Color.DARK_GRAY); // Cambiar color de texto a gris oscuro
        add(lblNewLabel, "cell 0 2,alignx trailing");

        txtNombreProducto = new JTextField();
        txtNombreProducto.setBackground(Color.LIGHT_GRAY); // Cambiar color de fondo a gris claro
        add(txtNombreProducto, "cell 1 2 6 1,growx");
        txtNombreProducto.setColumns(10);

        JLabel lblNewLabel_1 = new JLabel("Precio");
        lblNewLabel_1.setForeground(Color.DARK_GRAY); // Cambiar color de texto a gris oscuro
        add(lblNewLabel_1, "cell 0 3,alignx trailing");

        txtPrecio = new JTextField();
        txtPrecio.setBackground(Color.LIGHT_GRAY); // Cambiar color de fondo a gris claro
        add(txtPrecio, "cell 1 3 6 1,growx");
        txtPrecio.setColumns(10);

        JLabel lblNewLabel_2 = new JLabel("¿Es perecedero?");
        lblNewLabel_2.setForeground(Color.DARK_GRAY); // Cambiar color de texto a gris oscuro
        add(lblNewLabel_2, "cell 0 4");

        radioButtonPerecedero = new JRadioButton("");
        add(radioButtonPerecedero, "cell 2 4,alignx center,aligny center");

        JButton btnNewButton = new JButton("Añadir");
        btnNewButton.setBackground(Color.GREEN); // Cambiar color de fondo a verde
        btnNewButton.setForeground(Color.WHITE); // Cambiar color de texto a blanco
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (validarCampos()) {
                    añadirProducto();
                }
            }
        });
        add(btnNewButton, "cell 12 8");
    }

    protected void añadirProducto() {
        double precio = 0.0;
        try {
            precio = Double.parseDouble(txtPrecio.getText());
        } catch (NumberFormatException e) {
            System.out.println("Error: El precio debe ser un número válido.");
        }

        boolean perecedero = radioButtonPerecedero.isSelected();

        Producto pro = new Producto(txtNombreProducto.getText(), precio, perecedero);
        if (!VentanaPrincipal.getListProductos().contains(pro)) {
            VentanaPrincipal.getListProductos().add(pro);
            System.out.println("Producto " + pro.getNombre() + " Añadido con Éxito");
            VentanaPrincipal.guardarProductos();
        } else {
            throw new IllegalArgumentException("Producto Repetido");
        }
    }

    private boolean validarCampos() {
        if (txtNombreProducto.getText().trim().isEmpty() || txtPrecio.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "No hay ningún dato introducido.", "Advertencia",
                    JOptionPane.WARNING_MESSAGE);
            return false;
        }
        return true;
    }
}
