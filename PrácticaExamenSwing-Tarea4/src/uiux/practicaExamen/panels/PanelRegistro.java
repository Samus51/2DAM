package uiux.practicaExamen.panels;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;
import uiux.models.Usuario;
import uiux.practicaExamen.VentanaLogin;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JPasswordField;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;

public class PanelRegistro extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txtNombre;
	private JTextField txtApellidos;
	private JTextField txtEmail;
	private JPasswordField passContraseña;
	private JPasswordField passConfirmarContraseña;
	private JPanel panelTitulo;
	private JPanel panelCampos;
	private JLabel lblNombre;
	private JLabel lblApellidos;
	private JDateChooser dateUsuario;
	private JLabel lblNacimiento;
	private JLabel lblPerfil;
	private JComboBox<String> cbPerfil;
	private JLabel lblEmail;
	private JLabel lblContraseña;
	private JLabel lblConfirmarContraseña;
	private VentanaLogin vetanin;

	public PanelRegistro(JFrame parent, boolean modal) {
				vetanin = (VentanaLogin) parent;
        this.setModal(modal);
				setBounds(100, 100, 524, 661);
        getContentPane().setLayout(new BorderLayout());
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        getContentPane().add(contentPanel, BorderLayout.CENTER);
        {
            panelTitulo = new JPanel();
            panelTitulo.setForeground(new Color(255, 255, 255));
            panelTitulo.setBackground(new Color(0, 191, 255));
            {
                JLabel lblTitulo = new JLabel("Registro de Usuario");
                lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
                lblTitulo.setForeground(new Color(255, 255, 255));
                lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 15));
                panelTitulo.add(lblTitulo);
            }
        }
        {
            panelCampos = new JPanel();

            lblNombre = new JLabel("Nombre");
            lblApellidos = new JLabel("Apellidos");
            lblNacimiento = new JLabel("Fecha de Nacimiento");
            lblPerfil = new JLabel("Perfil");
            lblEmail = new JLabel("Email");
            lblContraseña = new JLabel("Contraseña");
            lblConfirmarContraseña = new JLabel("Confirmar Contraseña");

            txtNombre = new JTextField();
            txtNombre.setColumns(10);

            txtApellidos = new JTextField();
            txtApellidos.setColumns(10);

            cbPerfil = new JComboBox<String>();
            cbPerfil.setModel(new DefaultComboBoxModel<String>(new String[] { "Cliente", "Administrador" }));

            passConfirmarContraseña = new JPasswordField();
        }
        GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
        gl_contentPanel.setHorizontalGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
                .addComponent(panelTitulo, GroupLayout.PREFERRED_SIZE, 478, GroupLayout.PREFERRED_SIZE)
                .addComponent(panelCampos, GroupLayout.DEFAULT_SIZE, 498, Short.MAX_VALUE));
        gl_contentPanel.setVerticalGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
                .addGroup(gl_contentPanel.createSequentialGroup()
                        .addComponent(panelTitulo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
                                GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(ComponentPlacement.RELATED)
                        .addComponent(panelCampos, GroupLayout.DEFAULT_SIZE, 566, Short.MAX_VALUE).addContainerGap()));
        panelCampos.setLayout(new GridLayout(0, 2, 10, 50));
        panelCampos.add(lblNombre);
        panelCampos.add(txtNombre);
        panelCampos.add(lblApellidos);
        panelCampos.add(txtApellidos);
        panelCampos.add(lblNacimiento);

        dateUsuario = new JDateChooser();
        panelCampos.add(dateUsuario);
        panelCampos.add(lblPerfil);
        panelCampos.add(cbPerfil);
        panelCampos.add(lblEmail);

        txtEmail = new JTextField();
        txtEmail.setColumns(10);
        panelCampos.add(txtEmail);
        panelCampos.add(lblContraseña);

        passContraseña = new JPasswordField();
        panelCampos.add(passContraseña);
        panelCampos.add(lblConfirmarContraseña);
        panelCampos.add(passConfirmarContraseña);

        JLabel lblNewLabel = new JLabel("");
        panelCampos.add(lblNewLabel);

        JButton btnNewButton = new JButton("Crear");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                guardarUsuario();
            }
        });
        panelCampos.add(btnNewButton);
        contentPanel.setLayout(gl_contentPanel);
    }

	protected void guardarUsuario() {
		String nombre = txtNombre.getText().trim();
		String apellidos = txtApellidos.getText().trim();
		Date fechaRaw = dateUsuario.getDate();
		String perfil = cbPerfil.getSelectedItem() != null ? cbPerfil.getSelectedItem().toString() : "";
		String email = txtEmail.getText().trim();
		String contraseña = new String(passContraseña.getPassword()).trim();
		String confirmContraseña = new String(passConfirmarContraseña.getPassword()).trim();

		if (nombre.isEmpty() || apellidos.isEmpty() || perfil.isEmpty() || email.isEmpty() || contraseña.isEmpty()
				|| confirmContraseña.isEmpty() || fechaRaw == null) {
			JOptionPane.showMessageDialog(this, "No se puede crear un usuario con campos vacíos.", "Error",
					JOptionPane.ERROR_MESSAGE);
			resetearCampos();
			return;
		}

		for (Usuario u : VentanaLogin.getListUsuarios()) {
			if (u.getEmail().trim().equalsIgnoreCase(email) && u.getNombre().trim().equalsIgnoreCase(nombre)
					&& u.getApellidos().trim().equalsIgnoreCase(apellidos)) {
				JOptionPane.showMessageDialog(this, "No puedes crear un usuario ya existente.");
				resetearCampos();
				return;
			}
		}

		SimpleDateFormat dt = new SimpleDateFormat("dd-MM-yyyy");
		String fechaNacimiento = dt.format(fechaRaw);

		Usuario user = new Usuario(nombre, apellidos, fechaNacimiento, perfil, email, contraseña);
		VentanaLogin.getListUsuarios().add(user);
		JOptionPane.showMessageDialog(this, "Usuario registrado exitosamente.");
		VentanaLogin.saveUsuarios();
		dispose();
	}

	private void resetearCampos() {
		txtNombre.setText("");
		txtApellidos.setText("");
		txtEmail.setText("");
		cbPerfil.setSelectedIndex(-1);
		passContraseña.setText("");
		passConfirmarContraseña.setText("");
		dateUsuario.setDate(null);
	}
}
