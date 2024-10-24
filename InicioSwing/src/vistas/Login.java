package vistas;

import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import modelos.Usuario;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.BoxLayout;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import net.miginfocom.swing.MigLayout;
import java.awt.FlowLayout;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextArea;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton btnLogin;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */

	public Login() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 690, 613);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);

		JLabel Logo = new JLabel("");
		Logo.setIcon(new ImageIcon(Login.class.getResource("/resources/logo.png")));

		JLabel lblNewLabel = new JLabel("Usuario");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 22));

		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 22));

		JTextArea txtUsuario = new JTextArea();
		txtUsuario.setForeground(new Color(0, 0, 0));

		JTextArea txtUsuario_1 = new JTextArea();
		txtUsuario_1.setForeground(Color.BLACK);

		btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				btnLoginPressed(e);

			}
		});
		btnLogin.setFont(new Font("Tahoma", Font.PLAIN, 14));

		JButton btnCrearCuenta = new JButton("Crear Cuenta");
		btnCrearCuenta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				btnCrearCuentaPressed(e);

			}
		});
		btnCrearCuenta.setFont(new Font("Tahoma", Font.PLAIN, 13));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup().addComponent(Logo).addContainerGap(35, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup().addGap(281).addComponent(lblNewLabel).addContainerGap(310,
						Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup().addGap(272)
						.addComponent(lblPassword, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(292, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup().addGap(217)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(txtUsuario_1, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 205, Short.MAX_VALUE)
								.addComponent(txtUsuario, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 205, Short.MAX_VALUE))
						.addGap(242))
				.addGroup(gl_contentPane.createSequentialGroup().addGap(146)
						.addComponent(btnLogin, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE).addGap(106)
						.addComponent(btnCrearCuenta, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(184, Short.MAX_VALUE)));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane
				.createSequentialGroup().addComponent(Logo).addPreferredGap(ComponentPlacement.UNRELATED)
				.addComponent(lblNewLabel).addGap(18)
				.addComponent(txtUsuario, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
				.addGap(18).addComponent(lblPassword, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE).addGap(18)
				.addComponent(txtUsuario_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
				.addGap(62)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnCrearCuenta, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnLogin, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE))
				.addContainerGap(182, Short.MAX_VALUE)));
		contentPane.setLayout(gl_contentPane);

	}

	protected void btnLoginPressed(ActionEvent e) {

		JOptionPane.showMessageDialog(btnLogin, "Perfecto");
	}

	protected void btnCrearCuentaPressed(ActionEvent e) {
		CrearCuentas frameCuenta = new CrearCuentas();
		frameCuenta.setVisible(true);

	}

}
