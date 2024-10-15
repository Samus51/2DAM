package uiux.swing.ejercicio02.screens;

import javax.swing.*;
import java.awt.*;

/**
 * Clase que representa la ventana para eliminar un cliente.
 * Permite buscar un cliente por nombre y confirmar su eliminación.
 */
public class BajaCliente extends JDialog {
    private static final long serialVersionUID = 1L;
    private JTextField nombreField;
    private JButton eliminarButton;
    private PantallaInicial pantalla;

    /**
     * Constructor de la clase BajaCliente.
     *
     * @param pantalla La instancia de PantallaInicial para acceder a la lista de clientes.
     */
    public BajaCliente(PantallaInicial pantalla) {
        this.pantalla = pantalla;
        setIconImage(new ImageIcon(getClass().getResource("/resources/iconoui.jpg")).getImage());
        setTitle("Baja Cliente");
        setSize(300, 100);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(2, 2));

        // Colores elegidos
        Color fondoDialogo = new Color(224, 255, 255); 
        Color textoColor = new Color(0, 0, 0);
        Color labelColor = new Color(0, 102, 204); 
        Color buttonColor = new Color(220, 20, 60); 

        // Configuración del fondo del diálogo
        getContentPane().setBackground(fondoDialogo);

        // Añadir etiquetas y campos
        JLabel nombreLabel = new JLabel("Nombre:");
        nombreLabel.setForeground(labelColor);
        add(nombreLabel);
        nombreField = new JTextField();
        add(nombreField);

        // Botón para eliminar cliente
        eliminarButton = new JButton("Eliminar Cliente");
        eliminarButton.setBackground(buttonColor);
        eliminarButton.setForeground(Color.WHITE); 
        eliminarButton.addActionListener(e -> {
            String nombre = nombreField.getText();

            // Validar que el cliente existe
            if (pantalla.getClientes().stream().noneMatch(cliente -> cliente.contains(nombre))) {
                JOptionPane.showMessageDialog(this, "El cliente no existe.", "Error",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }

            int confirm = JOptionPane.showConfirmDialog(this,
                    "¿Está seguro de que desea eliminar al cliente " + nombre + "?", "Confirmar Eliminar",
                    JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                pantalla.eliminarCliente(nombre);
                dispose();
            }
        });
        add(new JLabel()); 
        add(eliminarButton);

        setModal(true); 
        setVisible(true);
    }
}
