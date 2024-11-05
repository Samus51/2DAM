package uiux.practicaExamen.panels;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import uiux.models.Clases;
import uiux.models.Reserva;
import uiux.models.Usuario;
import uiux.practicaExamen.VentanaLogin;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;

public class PanelReservarClase extends JDialog {
    private static final long serialVersionUID = 1L;
    private JComboBox<String> cbClase;
    private JComboBox<String> cbTurno;
    private Usuario usuario;
    private PanelHomeCliente pantallaPrincipal;

    public PanelReservarClase(Usuario usuarioConectado, JFrame parent, boolean modal) {
        pantallaPrincipal = (PanelHomeCliente) parent;
        this.setModal(modal);

        usuario = usuarioConectado;
        initialize();
        cargarClasesDisponibles();
    }

    private void initialize() {
        setBounds(100, 100, 450, 300);
        getContentPane().setLayout(new BorderLayout());

        JPanel buttonPane = new JPanel();
        buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
        getContentPane().add(buttonPane, BorderLayout.SOUTH);

        JButton btnReservar = new JButton("Reservar");
        btnReservar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                reservarClase();
            }
        });
        buttonPane.add(btnReservar);

        JPanel panel = new JPanel();
        panel.setBackground(new Color(135, 206, 250));
        getContentPane().add(panel, BorderLayout.NORTH);

        JLabel lblNewLabel = new JLabel("Reservar Clase");
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblNewLabel.setForeground(new Color(255, 255, 255));
        panel.add(lblNewLabel);

        JPanel centerPanel = new JPanel();
        getContentPane().add(centerPanel, BorderLayout.CENTER);
        GridBagLayout gbl_panel = new GridBagLayout();
        gbl_panel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
        centerPanel.setLayout(gbl_panel);

        JLabel lblNewLabel_1 = new JLabel("Clase");
        GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
        gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
        gbc_lblNewLabel_1.gridx = 1;
        gbc_lblNewLabel_1.gridy = 2;
        centerPanel.add(lblNewLabel_1, gbc_lblNewLabel_1);

        cbClase = new JComboBox<>();
        cbClase.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                actualizarTurnos();
            }
        });
        GridBagConstraints gbc_cbClase = new GridBagConstraints();
        gbc_cbClase.gridwidth = 4;
        gbc_cbClase.insets = new Insets(0, 0, 5, 5);
        gbc_cbClase.fill = GridBagConstraints.HORIZONTAL;
        gbc_cbClase.gridx = 5;
        gbc_cbClase.gridy = 2;
        centerPanel.add(cbClase, gbc_cbClase);

        JLabel lblNewLabel_2 = new JLabel("Turno");
        GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
        gbc_lblNewLabel_2.insets = new Insets(0, 0, 0, 5);
        gbc_lblNewLabel_2.gridx = 1;
        gbc_lblNewLabel_2.gridy = 4;
        centerPanel.add(lblNewLabel_2, gbc_lblNewLabel_2);

        cbTurno = new JComboBox<>();
        GridBagConstraints gbc_cbTurno = new GridBagConstraints();
        gbc_cbTurno.gridwidth = 4;
        gbc_cbTurno.insets = new Insets(0, 0, 0, 5);
        gbc_cbTurno.fill = GridBagConstraints.HORIZONTAL;
        gbc_cbTurno.gridx = 5;
        gbc_cbTurno.gridy = 4;
        centerPanel.add(cbTurno, gbc_cbTurno);
    }

    private void cargarClasesDisponibles() {
        List<Clases> clases = VentanaLogin.getListClases();
        DefaultComboBoxModel<String> modeloClase = new DefaultComboBoxModel<>();

        for (Clases clase : clases) {
            String item = clase.getNombre() + " - " + clase.getProfesor();
            if (((DefaultComboBoxModel<String>) cbClase.getModel()).getIndexOf(item) == -1) {
                modeloClase.addElement(item);
            }
        }

        cbClase.setModel(modeloClase);

        if (modeloClase.getSize() > 0) {
            cbClase.setSelectedIndex(0);
            actualizarTurnos();
        }
    }

    private void actualizarTurnos() {
        String claseSeleccionada = (String) cbClase.getSelectedItem();
        cbTurno.removeAllItems();

        if (claseSeleccionada != null) {
            String[] partes = claseSeleccionada.split(" - ");
            String nombreClase = partes[0];
            String profesor = partes[1];

            for (Clases clase : VentanaLogin.getListClases()) {
                if (clase.getNombre().equals(nombreClase) && clase.getProfesor().equals(profesor)) {
                    cbTurno.addItem(clase.getTurno());
                }
            }
        }
    }

    protected void reservarClase() {
        String claseSeleccionada = (String) cbClase.getSelectedItem();
        String turnoSeleccionado = (String) cbTurno.getSelectedItem();

        if (claseSeleccionada != null && turnoSeleccionado != null) {
            Clases claseReservada = null;

            String[] partes = claseSeleccionada.split(" - ");
            String nombreClase = partes[0];
            String profesor = partes[1];

            for (Clases clase : VentanaLogin.getListClases()) {
                if (clase.getNombre().equals(nombreClase) && clase.getProfesor().equals(profesor)
                        && clase.getTurno().equals(turnoSeleccionado)) {
                    claseReservada = clase;
                    break;
                }
            }

            if (claseReservada != null) {
                Reserva reserva = new Reserva(usuario, claseReservada);
                VentanaLogin.getListReservas().add(reserva);
                VentanaLogin.saveReservas();
                JOptionPane.showMessageDialog(this,
                        "Reserva confirmada para: " + nombreClase + " en el turno " + turnoSeleccionado);
                dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Error al realizar la reserva. Clase no encontrada.");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Selecciona una clase y un turno para reservar.");
        }
    }
}
