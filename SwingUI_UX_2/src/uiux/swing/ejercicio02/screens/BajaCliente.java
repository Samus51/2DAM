package uiux.swing.ejercicio02.screens;

import javax.swing.*;
import java.awt.*;

/**
 * Clase que representa la ventana para eliminar un cliente.
 * Permite buscar un cliente por nombre y confirmar su eliminación.
 */
<<<<<<< HEAD
public class BajaCliente extends JDialog {
=======
public class BajaCliente extends JFrame {
>>>>>>> d7bf18b3bf8bd8f10fbc24ebdf3e0e1e78507536
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
        setTitle("Baja Cliente");
        setSize(300, 100);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(2, 2));

        add(new JLabel("Nombre:"));
        nombreField = new JTextField();
        add(nombreField);

        eliminarButton = new JButton("Eliminar Cliente");
        eliminarButton.addActionListener(e -> {
            String nombre = nombreField.getText();
<<<<<<< HEAD
            
=======
>>>>>>> d7bf18b3bf8bd8f10fbc24ebdf3e0e1e78507536
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

        setVisible(true);
    }
}
