package uiux.ejercicio03.panels;

import javax.swing.*;
import uiuc.models.Cliente;
import uiux.ejercicio03.VentanaPrincipal;

import java.awt.*;
import net.miginfocom.swing.MigLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PanelEliminarCliente extends JPanel {
    private static final long serialVersionUID = 1L;
    private JTextField txtNombre;
    private JTextField txtEmail;

    public PanelEliminarCliente() {
        setBackground(new Color(139, 0, 0));
        setLayout(new MigLayout("", "[][159px,grow][][][][][][][]", "[25px][][][][][][][][]"));

        JLabel label = new JLabel("Eliminar Cliente");
        label.setFont(new Font("Tahoma", Font.BOLD, 20));
        add(label, "cell 1 0 4 1,grow");

        JLabel lblNewLabel = new JLabel("Nombre");
        add(lblNewLabel, "cell 0 3");

        txtNombre = new JTextField();
        add(txtNombre, "cell 1 3,growx");
        txtNombre.setColumns(10);

        JLabel lblNewLabel_1 = new JLabel("Email");
        add(lblNewLabel_1, "cell 0 5,alignx trailing");

        txtEmail = new JTextField();
        add(txtEmail, "cell 1 5,growx");
        txtEmail.setColumns(10);

        JButton btnNewButton = new JButton("Eliminar");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (validarCampos()) {
                    if (eliminarCliente()) {
                        JOptionPane.showMessageDialog(PanelEliminarCliente.this, "Cliente eliminado con éxito.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                        limpiarCampos();
                    } else {
                        JOptionPane.showMessageDialog(PanelEliminarCliente.this, "Cliente no encontrado con los datos proporcionados.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });
        add(btnNewButton, "cell 6 8");
    }

    private boolean eliminarCliente() {
        String nombre = txtNombre.getText();
        String email = txtEmail.getText();

        Cliente clienteAEliminar = null;
        for (Cliente cl : VentanaPrincipal.getListClientes()) {
            if (cl.getNombre().equalsIgnoreCase(nombre) && cl.getEmail().equalsIgnoreCase(email)) {
                clienteAEliminar = cl;
                break;
            }
        }

        if (clienteAEliminar != null) {
            VentanaPrincipal.getListClientes().remove(clienteAEliminar);
            VentanaPrincipal.guardarClientes();
            return true; // Indicar que el cliente fue eliminado
        }
        return false; // Indicar que no se encontró el cliente
    }

    private boolean validarCampos() {
        if (txtNombre.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "El nombre no puede estar vacío.", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return false;
        }
        if (txtEmail.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "El email no puede estar vacío.", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return false;
        }
        return true;
    }

    private void limpiarCampos() {
        txtNombre.setText("");
        txtEmail.setText("");
    }
}
