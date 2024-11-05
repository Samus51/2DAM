package uiux.practicaExamen.panels;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import uiux.models.Usuario;
import uiux.practicaExamen.VentanaLogin;

import javax.swing.RowFilter;

public class PanelTablaClientesAdministrador extends JDialog {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtFiltrador;
	private JTable tableClientes;
	PanelHomeAdministrador padre;
	private JLabel lblFiltrado;

	/**
	 * Create the frame.
	 */
	public PanelTablaClientesAdministrador(JFrame parent, boolean modal) {
		initialize();
		cargarUsuariosEnTabla();
		padre = (PanelHomeAdministrador) parent;
		this.setModal(modal);
	}

	/**
	 * Metodo que inicializa los componentes de la ventana
	 */
	private void initialize() {
		setBounds(100, 100, 450, 300);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		JPanel panelTitulo = new JPanel();
		panelTitulo.setBackground(new Color(135, 206, 250));
		contentPane.add(panelTitulo, BorderLayout.NORTH);

		JLabel lblNewLabel = new JLabel("Listar Clientes");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		panelTitulo.add(lblNewLabel);

		JPanel panelFooter = new JPanel();
		panelFooter.setBackground(new Color(135, 206, 250));
		contentPane.add(panelFooter, BorderLayout.SOUTH);

		lblFiltrado = new JLabel("Filtrado");
		lblFiltrado.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblFiltrado.setForeground(new Color(255, 255, 255));
		panelFooter.add(lblFiltrado);

		txtFiltrador = new JTextField();
		panelFooter.add(txtFiltrador);
		txtFiltrador.setColumns(10);

		JButton btnFiltrar = new JButton("Filtrar");
		btnFiltrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				filtrarDatos();
			}
		});
		panelFooter.add(btnFiltrar);

		JPanel panelDatos = new JPanel();
		contentPane.add(panelDatos, BorderLayout.CENTER);
		panelDatos.setLayout(new BorderLayout(0, 0));

		JScrollPane scrollPane = new JScrollPane();
		panelDatos.add(scrollPane, BorderLayout.NORTH);

		tableClientes = new JTable();
		tableClientes.setModel(new DefaultTableModel(
				new Object[][] { { null, null, null, null }, { null, null, null, null }, { null, null, null, null },
						{ null, null, null, null }, { null, null, null, null }, },
				new String[] { "Nombre", "Apellidos", "Fecha de Nacimiento", "Email" }));

		tableClientes.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				manejadorColumnas(e);
			}
		});

		scrollPane.setViewportView(tableClientes);
	}

	/**
	 * Metodo que maneja la columna que selecciones y que muestra cual filtras
	 * 
	 * @param e
	 */
	protected void manejadorColumnas(MouseEvent e) {
		int column = tableClientes.columnAtPoint(e.getPoint());
		String columnName = tableClientes.getColumnName(column);
		lblFiltrado.setText("Filtrado por: " + columnName);

	}

	/**
	 * Metodo que filtra los datos del campo filtrador segun la columna que
	 * selecciones o en general de todos los campos
	 */
	protected void filtrarDatos() {
		DefaultTableModel model = (DefaultTableModel) tableClientes.getModel();
		TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(model);
		tableClientes.setRowSorter(sorter);

		String filterText = txtFiltrador.getText().trim();

		if (filterText.isEmpty()) {
			sorter.setRowFilter(null);
		} else {
			List<RowFilter<DefaultTableModel, Integer>> filters = new ArrayList<>();
			filters.add(RowFilter.regexFilter("(?i)" + filterText, 0));
			filters.add(RowFilter.regexFilter("(?i)" + filterText, 1));
			filters.add(RowFilter.regexFilter("(?i)" + filterText, 2));
			filters.add(RowFilter.regexFilter("(?i)" + filterText, 3));

			RowFilter<DefaultTableModel, Integer> rowFilter = RowFilter.orFilter(filters);
			sorter.setRowFilter(rowFilter);

		}
	}

	/**
	 * Metodo que carga los usuarios en la tabla de la pantalla y hace una carga de
	 * estos datos en forma de depuracion
	 */
	private void cargarUsuariosEnTabla() {
		DefaultTableModel model = (DefaultTableModel) tableClientes.getModel();
		model.setRowCount(0);

		for (Usuario user : VentanaLogin.getListUsuarios()) {
			if (user.getPerfil().equals("Cliente")) {
				System.out.println("Cargando: " + user.getNombre() + ", " + user.getApellidos() + ", "
						+ user.getFechaNacimiento() + ", " + user.getEmail());
				model.addRow(new Object[] { user.getNombre(), user.getApellidos(), user.getFechaNacimiento(),
						user.getEmail() });

			}
		}
	}

	/**
	 * Metodo para filtrar por campos en el buscador de filtrado segun usuarios y
	 * sus datos
	 */
	protected void filtradoRow() {
		DefaultTableModel model = (DefaultTableModel) tableClientes.getModel();
		TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(model);

		tableClientes.setRowSorter(sorter);

		RowFilter<DefaultTableModel, Integer> rowFilter = RowFilter.regexFilter(txtFiltrador.getText(), 0);
		sorter.setRowFilter(rowFilter);
	}
}
