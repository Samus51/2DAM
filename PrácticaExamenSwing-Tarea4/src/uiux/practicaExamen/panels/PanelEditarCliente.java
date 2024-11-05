package uiux.practicaExamen.panels;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import com.toedter.calendar.JDateChooser;

import uiux.models.Usuario;
import uiux.practicaExamen.VentanaLogin;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PanelEditarCliente extends JDialog {

	private static final long serialVersionUID = 1L;
	private JTextField txtEmailVerificador;
	private JTextField txtNombre;
	private JTextField txtApellidos;
	private JPasswordField passContraseña;
	private JPasswordField passConfirmContraseña;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			PanelEditarCliente dialog = new PanelEditarCliente();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public PanelEditarCliente() {
		setBounds(100, 100, 450, 300);
		{
			JPanel panelPadre = new JPanel();
			getContentPane().add(panelPadre, BorderLayout.CENTER);
			panelPadre.setLayout(new BorderLayout(0, 0));
			{
				JPanel panel = new JPanel();
				panel.setBackground(new Color(135, 206, 250));
				panelPadre.add(panel, BorderLayout.NORTH);
				{
					JLabel lblTitulo = new JLabel("Editar Usuario");
					lblTitulo.setForeground(new Color(255, 255, 255));
					lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 14));
					panel.add(lblTitulo);
				}
			}
			{
				JPanel panel = new JPanel();
				panelPadre.add(panel, BorderLayout.CENTER);
				
				JLabel lblNewLabel = new JLabel("Introuzca el email del usuario a cambiar");
				
				JLabel lblNewLabel_1 = new JLabel("Nombre");
				
				JLabel lblNewLabel_2 = new JLabel("Apellidos");
				
				JLabel lblNewLabel_3 = new JLabel("Fecha de Nacimiento");
				
				JLabel lblNewLabel_4 = new JLabel("Perfil");
				
				JLabel lblNewLabel_5 = new JLabel("Contraseña");
				
				JLabel lblNewLabel_6 = new JLabel("Confirmar Contraseña");
				
				txtEmailVerificador = new JTextField();
				txtEmailVerificador.setColumns(10);
				
				txtNombre = new JTextField();
				txtNombre.setColumns(10);
				
				txtApellidos = new JTextField();
				txtApellidos.setColumns(10);
				
				passContraseña = new JPasswordField();
				
				passConfirmContraseña = new JPasswordField();
				
				JDateChooser dateUsuario = new JDateChooser();
				
				JComboBox<String> cbPerfil = new JComboBox<String>();
				cbPerfil.setModel(new DefaultComboBoxModel<String>(new String[] {"Administrador", "Cliente"}));
				
				JButton btnNewButton = new JButton("Guardar Cambios");
				btnNewButton.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
					editarUsuario();
					}
				});
				GroupLayout gl_panel = new GroupLayout(panel);
				gl_panel.setHorizontalGroup(
					gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup()
									.addGap(19)
									.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
										.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(txtEmailVerificador)))
								.addGroup(gl_panel.createSequentialGroup()
									.addGap(58)
									.addComponent(btnNewButton)))
							.addGap(132)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(lblNewLabel_1)
									.addPreferredGap(ComponentPlacement.RELATED, 159, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
									.addGroup(gl_panel.createSequentialGroup()
										.addComponent(lblNewLabel_2)
										.addPreferredGap(ComponentPlacement.RELATED, 154, GroupLayout.PREFERRED_SIZE))
									.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
										.addComponent(lblNewLabel_3)
										.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
											.addGroup(gl_panel.createSequentialGroup()
												.addComponent(lblNewLabel_4)
												.addPreferredGap(ComponentPlacement.RELATED, 172, GroupLayout.PREFERRED_SIZE))
											.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
												.addGroup(gl_panel.createSequentialGroup()
													.addComponent(lblNewLabel_5)
													.addPreferredGap(ComponentPlacement.RELATED, 140, GroupLayout.PREFERRED_SIZE))
												.addGroup(gl_panel.createSequentialGroup()
													.addComponent(lblNewLabel_6)
													.addPreferredGap(ComponentPlacement.RELATED)
													.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
														.addComponent(passContraseña, GroupLayout.DEFAULT_SIZE, 78, Short.MAX_VALUE)
														.addComponent(passConfirmContraseña)
														.addComponent(cbPerfil, 0, 81, Short.MAX_VALUE)
														.addComponent(dateUsuario, GroupLayout.DEFAULT_SIZE, 82, Short.MAX_VALUE)
														.addComponent(txtApellidos, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
														.addComponent(txtNombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))))))
							.addGap(39))
				);
				gl_panel.setVerticalGroup(
					gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(39)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup()
									.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
										.addGroup(gl_panel.createSequentialGroup()
											.addComponent(lblNewLabel_1)
											.addGap(18))
										.addGroup(gl_panel.createSequentialGroup()
											.addPreferredGap(ComponentPlacement.RELATED, 1, GroupLayout.PREFERRED_SIZE)
											.addComponent(txtNombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.UNRELATED)))
									.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
										.addComponent(lblNewLabel_2)
										.addComponent(txtApellidos, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
									.addGap(18)
									.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
										.addComponent(lblNewLabel_3)
										.addComponent(dateUsuario, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
									.addGap(18)
									.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
										.addComponent(lblNewLabel_4)
										.addComponent(cbPerfil, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
									.addGap(18)
									.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
										.addComponent(lblNewLabel_5)
										.addComponent(passContraseña, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
										.addComponent(lblNewLabel_6)
										.addComponent(passConfirmContraseña, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(lblNewLabel)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(txtEmailVerificador, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addGap(53)
									.addComponent(btnNewButton)))
							.addContainerGap(29, Short.MAX_VALUE))
				);
				panel.setLayout(gl_panel);
			}
		}
	}

	protected void editarUsuario() {

		for(Usuario cl1 : VentanaLogin.getListUsuarios()) {
			
		}
	}
}
