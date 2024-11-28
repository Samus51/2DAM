package examen.views;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.GridBagLayout;
import net.miginfocom.swing.MigLayout;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;

public class Registro extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txtNombre;
	private JTextField txtApellidos;
	private JTextField txtEmail;
	private JPasswordField passwordField;
	private JPasswordField passwordConfirm;
	private final ButtonGroup buttonGroup = new ButtonGroup();


	/**
	 * Create the dialog.
	 */
	public Registro() {
		setBounds(100, 100, 324, 516);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(30, 144, 255));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			contentPanel.add(panel, BorderLayout.WEST);
		}
		{
			JPanel panel = new JPanel();
			contentPanel.add(panel, BorderLayout.SOUTH);
		}
		{
			JPanel panel = new JPanel();
			contentPanel.add(panel, BorderLayout.EAST);
		}
		{
			JPanel panel = new JPanel();
			panel.setBackground(new Color(30, 144, 255));
			contentPanel.add(panel, BorderLayout.NORTH);
			{
				JLabel lblNewLabel = new JLabel("");
				lblNewLabel.setIcon(new ImageIcon(Registro.class.getResource("/utils/Logo.png")));
				panel.add(lblNewLabel);
			}
		}
		{
			JPanel panel = new JPanel();
			contentPanel.add(panel, BorderLayout.CENTER);
			panel.setLayout(new MigLayout("", "[][][][][][grow]", "[][][][][][grow][][][][][][][][][]"));
			{
				JLabel lblNewLabel_1 = new JLabel("Nombre");
				panel.add(lblNewLabel_1, "cell 0 1");
			}
			{
				txtNombre = new JTextField();
				panel.add(txtNombre, "cell 4 1 2 1,growx");
				txtNombre.setColumns(10);
			}
			{
				JLabel lblNewLabel_2 = new JLabel("Apellidos");
				panel.add(lblNewLabel_2, "cell 0 3");
			}
			{
				txtApellidos = new JTextField();
				panel.add(txtApellidos, "cell 4 3 2 1,growx");
				txtApellidos.setColumns(10);
			}
			{
				JLabel lblNewLabel_3 = new JLabel("Fecha de Nacimiento");
				panel.add(lblNewLabel_3, "cell 0 5");
			}
			{
				JDateChooser dateChooser = new JDateChooser();
				panel.add(dateChooser, "cell 4 5 2 1,grow");
			}
			{
				JLabel lblNewLabel_4 = new JLabel("Email");
				panel.add(lblNewLabel_4, "cell 0 7");
			}
			{
				txtEmail = new JTextField();
				panel.add(txtEmail, "cell 4 7 2 1,growx");
				txtEmail.setColumns(10);
			}
			{
				JLabel lblNewLabel_5 = new JLabel("Contraseña");
				panel.add(lblNewLabel_5, "cell 0 9");
			}
			{
				passwordField = new JPasswordField();
				panel.add(passwordField, "cell 4 9 2 1,growx");
			}
			{
				JLabel lblNewLabel_6 = new JLabel("Confirmar Contraseña");
				panel.add(lblNewLabel_6, "cell 0 11");
			}
			{
				passwordConfirm = new JPasswordField();
				panel.add(passwordConfirm, "cell 4 11 2 1,growx");
			}
			{
				JLabel lblNewLabel_7 = new JLabel("Perfil de Usuario");
				panel.add(lblNewLabel_7, "cell 0 13");
			}
			{
				JRadioButton rdbJugador = new JRadioButton("Jugador");
				buttonGroup.add(rdbJugador);
				panel.add(rdbJugador, "cell 4 13");
			}
			{
				JRadioButton rdbEntrenador = new JRadioButton("Entrenador");
				buttonGroup.add(rdbEntrenador);
				panel.add(rdbEntrenador, "cell 5 13");
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(new Color(30, 144, 255));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnRegistrar = new JButton("Registrar");
				btnRegistrar.setActionCommand("OK");
				buttonPane.add(btnRegistrar);
				getRootPane().setDefaultButton(btnRegistrar);
			}
			{
				JButton btnCancelar = new JButton("Cancelar");
				btnCancelar.setActionCommand("Cancel");
				buttonPane.add(btnCancelar);
			}
		}
	}

}
