package uiux.practicaExamen.panels;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.RowFilter;
import uiux.models.Reserva;
import uiux.practicaExamen.VentanaLogin;

public class PanelTablaClasesAdministrador extends JDialog {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtFiltrador;
	private JTable tableClases;
	private JLabel lblFiltrado;
	PanelHomeAdministrador pantallaPrincipal;
	private int selectedColumnIndex = 0;

	public PanelTablaClasesAdministrador(JFrame parent, boolean modal) {
		initialize();
		cargarReservasEnTabla();
		pantallaPrincipal = (PanelHomeAdministrador) parent;
		this.setModal(modal);

	}

	/**
	 * Metodo que inicializa los componentes de la ventana
	 */
	private void initialize() {
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		JPanel panelTitulo = new JPanel();
		panelTitulo.setBackground(new Color(135, 206, 250));
		contentPane.add(panelTitulo, BorderLayout.NORTH);

		JLabel lblNewLabel = new JLabel("Listar Clases");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setForeground(Color.WHITE);
		panelTitulo.add(lblNewLabel);

		JPanel panelFooter = new JPanel();
		panelFooter.setBackground(new Color(135, 206, 250));
		contentPane.add(panelFooter, BorderLayout.SOUTH);

		lblFiltrado = new JLabel("Filtrado: ");
		lblFiltrado.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblFiltrado.setForeground(Color.WHITE);
		panelFooter.add(lblFiltrado);

		txtFiltrador = new JTextField();
		panelFooter.add(txtFiltrador);
		txtFiltrador.setColumns(10);

		JButton btnNewButton = new JButton("Filtrar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				filtrarDatos();
			}
		});
		panelFooter.add(btnNewButton);

		JPanel panelDatos = new JPanel();
		contentPane.add(panelDatos, BorderLayout.CENTER);
		panelDatos.setLayout(new BorderLayout(0, 0));

		JScrollPane scrollPane = new JScrollPane();
		panelDatos.add(scrollPane, BorderLayout.NORTH);

		tableClases = new JTable();
		tableClases.setModel(new DefaultTableModel(
				new Object[][] { { null, null, null, null }, { null, null, null, null }, { null, null, null, null },
						{ null, null, null, null }, { null, null, null, null }, },
				new String[] { "Nombre", "Apellidos", "Clase", "Turno" }));

		tableClases.getTableHeader().addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				manejadorColumnas(e);
			}
		});

		scrollPane.setViewportView(tableClases);

	}

	/**
	 * Metodo que maneja la columna y muestra por cual filtra
	 * 
	 * @param e
	 */
	private void manejadorColumnas(MouseEvent e) {
		int column = tableClases.columnAtPoint(e.getPoint());
		if (column >= 0) {
			selectedColumnIndex = column;
			lblFiltrado.setText("Filtrado: " + tableClases.getColumnName(column));
			txtFiltrador.setText("");
		}
	}

	/**
	 * Metodo que filtra los datos segun la columna o por cualquier dato de la tabla
	 */
	protected void filtrarDatos() {
		DefaultTableModel model = (DefaultTableModel) tableClases.getModel();
		TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(model);
		tableClases.setRowSorter(sorter);

		int columnIndex = selectedColumnIndex;
		String filterText = txtFiltrador.getText().trim();

		if (filterText.isEmpty()) {
			sorter.setRowFilter(null);
		} else {
			try {
				RowFilter<DefaultTableModel, Integer> rowFilter = RowFilter.regexFilter("(?i)" + filterText,
						columnIndex);
				sorter.setRowFilter(rowFilter);
			} catch (java.util.regex.PatternSyntaxException e) {
				System.err.println("El texto de filtrado no es válido: " + e.getMessage());
			}
		}
	}

	/**
	 * Método que carga los datos en la tabla
	 */
	private void cargarReservasEnTabla() {
		DefaultTableModel model = (DefaultTableModel) tableClases.getModel();
		model.setRowCount(0);

		for (Reserva res : VentanaLogin.getListReservas()) {
			model.addRow(new Object[] { res.getUsuario().getNombre(), res.getUsuario().getApellidos(),
					res.getClaseReservada().getNombre(), res.getClaseReservada().getTurno() });
		}
	}
}
