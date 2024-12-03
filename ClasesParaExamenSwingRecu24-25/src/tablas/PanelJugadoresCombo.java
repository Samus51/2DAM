package tablas;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import javax.swing.JScrollPane;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class PanelJugadoresCombo extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField txtApellidos;
	private JTable table;
	private JComboBox<String> comboEquipos;  // ComboBox para los equipos

	/**
	 * Create the panel.
	 */
	public PanelJugadoresCombo() {
		inicializarComponentes();
		cargarEquiposEnComboBox();
	}


	/**
	 * Panel Jugadores con ComboBox aqui te mira tu el codigo y te lo sacas
	 * mas o menos es casi lo mismo
	 */
	
	private void inicializarComponentes() {
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		add(panel, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("Jugadores");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		add(panel_1, BorderLayout.SOUTH);
		
		JLabel lblNewLabel_1 = new JLabel("Equipo");
		panel_1.add(lblNewLabel_1);
		
		// Inicializamos el JComboBox para los equipos
		comboEquipos = new JComboBox<>();
		comboEquipos.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				cargarJugadoresEnTabla((String) comboEquipos.getSelectedItem());  // Cargar jugadores cuando se seleccione un equipo
			}
		});
		panel_1.add(comboEquipos);
		
		JLabel lblNewLabel_2 = new JLabel("Apellidos");
		panel_1.add(lblNewLabel_2);
		
		txtApellidos = new JTextField();
		txtApellidos.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				filtrarJugadores();
			}
		});
		panel_1.add(txtApellidos);
		txtApellidos.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
			},
			new String[] {
				"Equipo", "Nombre", "Apellidos", "Fecha nacimiento", "Email"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(102);
		table.getColumnModel().getColumn(1).setPreferredWidth(116);
		table.getColumnModel().getColumn(2).setPreferredWidth(127);
		table.getColumnModel().getColumn(3).setPreferredWidth(97);
		table.getColumnModel().getColumn(4).setPreferredWidth(142);
		scrollPane.setViewportView(table);
	}

	// Cargar los equipos en el ComboBox
	private void cargarEquiposEnComboBox() {
		for (Equipo equipo : Launcher.lstEquipos) {
			comboEquipos.addItem(equipo.getNombre());
		}
	}

	// Cargar jugadores en la tabla según el equipo seleccionado
	private void cargarJugadoresEnTabla(String equipoSeleccionado) {
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.setRowCount(0); // Limpiar la tabla antes de cargar nuevos datos

		for (Equipo equipo : Launcher.lstEquipos) {
			if (equipo.getNombre().equalsIgnoreCase(equipoSeleccionado)) {
				for (Usuario jugador : equipo.getLstJugadores()) {
					model.addRow(new Object[] {
						equipo.getNombre(),
						jugador.getNombre(),
						jugador.getApellidos(),
						jugador.getFechaNacimiento(),
						jugador.getEmail()
					});
				}
			}
		}
	}

	// Filtrar jugadores por apellidos
	protected void filtrarJugadores() {
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(model);
		table.setRowSorter(sorter);

		String apellidoFiltro = txtApellidos.getText().trim();

		if (apellidoFiltro.isEmpty()) {
			sorter.setRowFilter(null); // Sin filtro
		} else {
			sorter.setRowFilter(RowFilter.regexFilter("(?i)" + apellidoFiltro, 2)); // Columna 2: Apellidos
		}
	}
}
