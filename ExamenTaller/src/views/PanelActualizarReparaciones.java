package views;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import main.Launcher;
import models.Empleado;
import models.Reparacion;

public class PanelActualizarReparaciones extends JDialog {

    private static final long serialVersionUID = 1L;
    private final JPanel contentPanel = new JPanel();
    private JComboBox<String> cbMatricula;
    private JLabel lblMarca;
    private JLabel lblModelo;
    private JLabel lblEstadoActual;
    private JComboBox<String> cbNuevoEstado;
    private JTextArea txtObservaciones;
    private JPanel panelOculto;
    private JTextField txtImporte;
    private Reparacion reparacionSeleccionada;
    private Empleado mecanicoLogado;
    public PanelActualizarReparaciones(Empleado user) {
        inicializarComponentes();
		this.setModal(true);
        cargaReparaciones();
    }

    private void inicializarComponentes() {
        setBounds(100, 100, 450, 300);
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new BorderLayout());
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        getContentPane().add(contentPanel, BorderLayout.CENTER);
        contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));

        JPanel panel = new JPanel();
        contentPanel.add(panel);
        panel.setLayout(new GridLayout(5, 2, 0, 0));

        panel.add(new JLabel("Matrícula", SwingConstants.CENTER));
        cbMatricula = new JComboBox<>();
        cbMatricula.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                actualizarDatos(); 
            }
        });
        panel.add(cbMatricula);

        panel.add(new JLabel("Marca", SwingConstants.CENTER));
        lblMarca = new JLabel("", SwingConstants.CENTER);
        panel.add(lblMarca);

        panel.add(new JLabel("Modelo", SwingConstants.CENTER));
        lblModelo = new JLabel("", SwingConstants.CENTER);
        panel.add(lblModelo);

        panel.add(new JLabel("Estado Actual", SwingConstants.CENTER));
        lblEstadoActual = new JLabel("", SwingConstants.CENTER);
        panel.add(lblEstadoActual);

        panel.add(new JLabel("Nuevo Estado", SwingConstants.CENTER));
        cbNuevoEstado = new JComboBox<>();
        cbNuevoEstado.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                verificarPanelOculto(); 
            }
        });
        panel.add(cbNuevoEstado);

        panelOculto = new JPanel();
        panelOculto.setLayout(new GridLayout(2, 2, 0, 0));
        panelOculto.setVisible(false);
        contentPanel.add(panelOculto);

        panelOculto.add(new JLabel("Importe", SwingConstants.CENTER));
        txtImporte = new JTextField();
        panelOculto.add(txtImporte);

        panelOculto.add(new JLabel("Observaciones", SwingConstants.CENTER));
        txtObservaciones = new JTextArea();
        panelOculto.add(txtObservaciones);

        JPanel buttonPane = new JPanel(new FlowLayout(FlowLayout.CENTER));
        getContentPane().add(buttonPane, BorderLayout.SOUTH);

        JButton btnAceptar = new JButton("Aceptar");
        btnAceptar.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnAceptar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                guardarCambios(); 
            }
        });
        buttonPane.add(btnAceptar);

        JButton cancelButton = new JButton("Cancelar");
        cancelButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        cancelButton.addActionListener(e -> dispose());
        buttonPane.add(cancelButton);

        JPanel headerPanel = new JPanel();
        headerPanel.setBackground(new Color(0, 0, 139));
        getContentPane().add(headerPanel, BorderLayout.NORTH);
        JLabel lblTitle = new JLabel("Actualizar Reparación");
        lblTitle.setFont(new Font("Tahoma", Font.BOLD, 11));
        lblTitle.setForeground(Color.WHITE);
        headerPanel.add(lblTitle);
    }
    private void cargaReparaciones() {
        DefaultComboBoxModel<String> model = (DefaultComboBoxModel<String>) cbMatricula.getModel();
        model.removeAllElements(); // Limpiar el modelo antes de agregar nuevas matrículas
        for (Reparacion rep : main.Launcher.lstReparaciones) {
            String matricula = rep.getCita().getVehiculo().getMatricula();
            // Solo añadir reparaciones que NO están finalizadas
            if (!"Finalizado".equals(rep.getEstado())) {
                model.addElement(matricula);
            }
        }
    }
    

    private void actualizarDatos() {
        String matriculaSeleccionada = (String) cbMatricula.getSelectedItem();
        if (matriculaSeleccionada == null) return;

        for (Reparacion rep : main.Launcher.lstReparaciones) {
            if (rep.getCita().getVehiculo().getMatricula().equals(matriculaSeleccionada)) {
                reparacionSeleccionada = rep;
                break;
            }
        }

        if (reparacionSeleccionada != null) {
            lblMarca.setText(reparacionSeleccionada.getCita().getVehiculo().getMarca());
            lblModelo.setText(reparacionSeleccionada.getCita().getVehiculo().getModelo());
            lblEstadoActual.setText(reparacionSeleccionada.getEstado());

            // Primero, eliminar los elementos existentes en el combo
            cbNuevoEstado.removeAllItems();

            // Ahora, añadir los nuevos elementos según el estado
            if ("Pendiente".equals(reparacionSeleccionada.getEstado())) {
                cbNuevoEstado.addItem("En curso");
            } else if ("En curso".equals(reparacionSeleccionada.getEstado())) {
                cbNuevoEstado.addItem("Finalizado");
            }

            // Esto es para mantener la selección de la matrícula
            cbMatricula.setSelectedItem(matriculaSeleccionada);

            // Verifica si el panel oculto debe ser visible
            verificarPanelOculto();
        }
    }

    private void verificarPanelOculto() {
        String nuevoEstado = (String) cbNuevoEstado.getSelectedItem();
        panelOculto.setVisible("Finalizado".equals(nuevoEstado));
    }

    private void guardarCambios() {
        if (reparacionSeleccionada != null) {
            String nuevoEstado = (String) cbNuevoEstado.getSelectedItem();
            reparacionSeleccionada.setEstado(nuevoEstado);

            if ("En curso".equals(nuevoEstado) && "Pendiente".equals(reparacionSeleccionada.getEstado())) {
            	reparacionSeleccionada.setEncargado(mecanicoLogado);
            }

            
            if ("Finalizado".equals(nuevoEstado)) {
                reparacionSeleccionada.setObservaciones(txtObservaciones.getText());
                try {
                    reparacionSeleccionada.setImporte(Double.parseDouble(txtImporte.getText()));
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "El importe debe ser numérico.", "Error",
                            JOptionPane.ERROR_MESSAGE);
                    return;
                }
            }

            JOptionPane.showMessageDialog(null, "Cambios guardados con éxito.", "Confirmación",
                    JOptionPane.INFORMATION_MESSAGE);
            cargaReparaciones();  // Refrescar combo con nuevas matrículas
            dispose();
        }
    }
}
