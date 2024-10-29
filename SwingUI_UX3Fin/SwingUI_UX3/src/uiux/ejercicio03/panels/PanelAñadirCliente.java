package uiux.ejercicio03.panels;

import javax.swing.*;
import java.awt.*;
import net.miginfocom.swing.MigLayout;
import uiuc.models.Cliente;
import uiux.ejercicio03.VentanaPrincipal;
import com.toedter.calendar.JDateChooser;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;

public class PanelAñadirCliente extends JPanel {
    private static final long serialVersionUID = 1L;
    private JTextField txtNombre;
    private JTextField txtApellidos;
    private JTextField txtEmail;
    private JComboBox<String> comboProvincia;
    private JDateChooser dateCliente;

    public PanelAñadirCliente() {
        Color colorFondo = Color.decode("#E0F7FA"); // Fondo del panel
        Color colorTexto = Color.decode("#00796B"); // Color del texto
        setBackground(colorFondo);
        setLayout(new MigLayout("", "[][78px,grow][grow][][][][][][grow][][][][][]",
                "[13px][][][][][][][][][][][][][][][][][][][][][][grow][][][][][][][][][]"));

        JLabel label = new JLabel("Añadir Cliente");
        label.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 30));
        label.setForeground(colorTexto); // Color del texto
        add(label, "cell 3 2");

        JLabel lblNewLabel = new JLabel("Nombre");
        lblNewLabel.setForeground(colorTexto); // Color del texto
        add(lblNewLabel, "cell 0 4,alignx trailing");

        txtNombre = new JTextField();
        add(txtNombre, "cell 1 4 4 1,growx");
        txtNombre.setColumns(10);

        JLabel lblApellidos = new JLabel("Apellidos");
        lblApellidos.setForeground(colorTexto); // Color del texto
        add(lblApellidos, "cell 0 6,alignx trailing");

        txtApellidos = new JTextField();
        txtApellidos.setColumns(10);
        add(txtApellidos, "cell 1 6 3 1,growx");

        JLabel lblEmail = new JLabel("Email");
        lblEmail.setForeground(colorTexto); // Color del texto
        add(lblEmail, "cell 0 8,alignx trailing");

        txtEmail = new JTextField();
        txtEmail.setColumns(10);
        add(txtEmail, "cell 1 8 3 1,growx");

        JLabel lblProvincia = new JLabel("Provincia");
        lblProvincia.setForeground(colorTexto); // Color del texto
        add(lblProvincia, "cell 0 10,alignx trailing");

        comboProvincia = new JComboBox<String>();
        comboProvincia.setModel(new DefaultComboBoxModel<String>(new String[] { "Madrid", "Barcelona", "Valencia",
                "Sevilla", "Málaga", "Alicante", "Zaragoza", "Córdoba", "Granada", "Bilbao" }));
        add(comboProvincia, "cell 1 10 3 1,growx");

        JLabel lblEdad = new JLabel("Edad");
        lblEdad.setForeground(colorTexto); // Color del texto
        add(lblEdad, "cell 0 12,alignx trailing");

        dateCliente = new JDateChooser();
        dateCliente.setPreferredSize(new Dimension(150, 25)); // Establecer tamaño preferido
        add(dateCliente, "cell 1 12 3 1");

        JButton btnAdd = new JButton("Añadir");
        btnAdd.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (validarCampos()) {
                    añadirCliente();
                }
            }
        });
        btnAdd.setBackground(Color.decode("#00796B")); // Color de fondo del botón
        btnAdd.setForeground(Color.WHITE); // Color del texto del botón
        add(btnAdd, "cell 11 12");
    }

    protected void añadirCliente() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        String formattedDate = dateFormat.format(dateCliente.getDate());

        Cliente cl = new Cliente(txtNombre.getText(), txtApellidos.getText(), txtEmail.getText(),
                comboProvincia.getSelectedItem().toString(), formattedDate);

        if (VentanaPrincipal.getListClientes().contains(cl)) {
            throw new IllegalArgumentException("Cliente Repetido");
        } else {
            VentanaPrincipal.getListClientes().add(cl);
            System.out.println("Cliente: " + cl.getNombre() + " añadido con éxito");

            VentanaPrincipal.guardarClientes();
        }
    }

    private boolean validarCampos() {
        if (txtNombre.getText().trim().isEmpty() || txtApellidos.getText().trim().isEmpty()
                || txtEmail.getText().trim().isEmpty() || comboProvincia.getSelectedItem().toString().isEmpty()
                || dateCliente.getDate() == null) {
            JOptionPane.showMessageDialog(this, "No hay ningún dato introducido.", "Advertencia",
                    JOptionPane.WARNING_MESSAGE);
            return false;
        }
        return true;
    }
}
