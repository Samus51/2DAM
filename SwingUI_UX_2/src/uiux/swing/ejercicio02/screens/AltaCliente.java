package uiux.swing.ejercicio02.screens;

import javax.swing.JPanel;
import javax.swing.JToolBar;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.Choice;
import com.toedter.calendar.JCalendar;
import javax.swing.JButton;
import com.toedter.calendar.JDateChooser;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AltaCliente extends JFrame {

	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JTextField textField_1;
	/**
	 * Create the panel.
	 */
	
	
	
	
	public AltaCliente() {
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nuevo Cliente");
		lblNewLabel.setBounds(166, 11, 152, 25);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		getContentPane().add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(66, 52, 86, 20);
		getContentPane().add(textField);
		textField.setColumns(10);
		textField_1 = new JTextField();
		textField_1.setBounds(66, 86, 86, 20);
		textField_1.setColumns(10);
		getContentPane().add(textField_1);
		
		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.setBounds(124, 122, 86, 22);
		comboBox.addItem("Ávila");
		comboBox.addItem("Albacete");
		comboBox.addItem("Alicante");
		comboBox.addItem("Almería");
		comboBox.addItem("Asturias");
		comboBox.addItem("Álava");
		comboBox.addItem("Baleares");
		comboBox.addItem("Barcelona");
		comboBox.addItem("Burgos");
		comboBox.addItem("Cáceres");
		comboBox.addItem("Cádiz");
		comboBox.addItem("Cantabria");
		comboBox.addItem("Ciudad Real");
		comboBox.addItem("Córdoba");
		comboBox.addItem("La Coruña");
		comboBox.addItem("Cuenca");
		comboBox.addItem("Gerona");
		comboBox.addItem("Granada");
		comboBox.addItem("Guadalajara");
		comboBox.addItem("Gipuzkoa");
		comboBox.addItem("Huelva");
		comboBox.addItem("Huesca");
		comboBox.addItem("Jaén");
		comboBox.addItem("La Rioja");
		comboBox.addItem("Las Palmas");
		comboBox.addItem("León");
		comboBox.addItem("Lleida");
		comboBox.addItem("Lugo");
		comboBox.addItem("Madrid");
		comboBox.addItem("Málaga");
		comboBox.addItem("Murcia");
		comboBox.addItem("Navarra");
		comboBox.addItem("Orense");
		comboBox.addItem("Palencia");
		comboBox.addItem("Pontevedra");
		comboBox.addItem("Salamanca");
		comboBox.addItem("Santa Cruz de Tenerife");
		comboBox.addItem("Segovia");
		comboBox.addItem("Sevilla");
		comboBox.addItem("Soria");
		comboBox.addItem("Tarragona");
		comboBox.addItem("Teruel");
		comboBox.addItem("Toledo");
		comboBox.addItem("Valencia");
		comboBox.addItem("Valladolid");
		comboBox.addItem("Vizcaya");
		comboBox.addItem("Zamora");
		comboBox.addItem("Zaragoza");
		getContentPane().add(comboBox);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(256, 114, 89, 23);
		getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("Nombre");
		lblNewLabel_1.setBounds(10, 55, 46, 14);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Apellidos");
		lblNewLabel_1_1.setBounds(10, 89, 46, 14);
		getContentPane().add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Provincia");
		lblNewLabel_1_1_1.setBounds(10, 167, 46, 14);
		getContentPane().add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_1_2 = new JLabel("Fecha de Nacimiento");
		lblNewLabel_1_1_2.setBounds(10, 114, 104, 39);
		getContentPane().add(lblNewLabel_1_1_2);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.getCalendarButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		dateChooser.setBounds(66, 167, 86, 20);
		getContentPane().add(dateChooser);

	}
  public static void main(String[] args) {
  	AltaCliente cli = new AltaCliente();
  	cli.setVisible(true);
  }
}
