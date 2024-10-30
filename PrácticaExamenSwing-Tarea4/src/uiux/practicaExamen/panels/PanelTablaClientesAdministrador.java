package uiux.practicaExamen.panels;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;

public class PanelTablaClientesAdministrador extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTable table;

	

	/**
	 * Create the frame.
	 */
	public PanelTablaClientesAdministrador() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 493, 402);
		
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));
		
		JPanel panelTitulo = new JPanel();
		panelTitulo.setBackground(new Color(72, 209, 204));
		panelTitulo.setForeground(new Color(127, 255, 212));
		panel.add(panelTitulo, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("Listar Clientes");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		panelTitulo.add(lblNewLabel);
		
		JPanel panelFoot = new JPanel();
		panel.add(panelFoot, BorderLayout.SOUTH);
		
		JLabel lblNewLabel_1 = new JLabel("Filtrado");
		panelFoot.add(lblNewLabel_1);
		
		textField = new JTextField();
		panelFoot.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Filtrar");
		panelFoot.add(btnNewButton);
		
		JPanel panelTabla = new JPanel();
		panel.add(panelTabla, BorderLayout.CENTER);
		panelTabla.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		panelTabla.add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
			},
			new String[] {
				"Nombre", "Apellidos", "Fecha de Nacimiento", "Email"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(115);
		table.getColumnModel().getColumn(1).setPreferredWidth(115);
		table.getColumnModel().getColumn(2).setPreferredWidth(115);
		table.getColumnModel().getColumn(3).setPreferredWidth(115);
		scrollPane.setViewportView(table);
	}
}
