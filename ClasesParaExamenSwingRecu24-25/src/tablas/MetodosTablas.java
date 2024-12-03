package tablas;

import java.util.ArrayList;
import java.util.List;

import javax.swing.RowFilter;
import javax.swing.RowSorter;
import javax.swing.SortOrder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;


public class MetodosTablas {
	
	/**
	 * Metodo basico para cargar datos en columnas de listas de objetos este es sencillito
	 */
	private void cargarJugadoresEnTabla() {
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.setRowCount(0); // Limpiar la tabla antes de cargar nuevos datos

		for (Equipo equipo : Launcher.lstEquipos) {
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
/**
 * Metodo para filtrar por campos de texto, este es de 2 campos relacionados
 */
	protected void filtrar2CamposTexto() {
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(model);
		table.setRowSorter(sorter);

		String equipoFiltro = txtEquipo.getText().trim();
		String apellidoFiltro = txtApellidos.getText().trim();

		if (equipoFiltro.isEmpty() && apellidoFiltro.isEmpty()) {
			sorter.setRowFilter(null); // Sin filtro
		} else {
			List<RowFilter<Object, Object>> filtros = new ArrayList<>();

			// Filtro por equipo
			if (!equipoFiltro.isEmpty()) {
				filtros.add(RowFilter.regexFilter("(?i)" + equipoFiltro, 0)); // Columna 0: Equipo
			}

			// Filtro por apellidos
			if (!apellidoFiltro.isEmpty()) {
				filtros.add(RowFilter.regexFilter("(?i)" + apellidoFiltro, 2)); // Columna 2: Apellidos
			}

			// Combinar filtros
			RowFilter<Object, Object> filtroCombinado = RowFilter.andFilter(filtros);
			sorter.setRowFilter(filtroCombinado);
		}
	}
/**
 * El mismo pero para 1 solo y con boton de accion en vez de evento key y seleccionando la columna para la cual filtraras
 */
	protected void filtrarDatosClickColumnaBoton() {
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
 * Metodo para filtrado de columnas segun que clickas de columnas
 */
	
	
	protected void filtrarDatosSoloClickColumna() {
		 int selectedColumnIndex = -1;  // Variable para almacenar el índice de la columna seleccionada
		DefaultTableModel modelo = (DefaultTableModel) tableClases.getModel();
	    TableRowSorter<DefaultTableModel> clasificador = new TableRowSorter<>(modelo);
	    tableClases.setRowSorter(clasificador);

	    int indiceColumna = selectedColumnIndex;  // El índice de la columna seleccionada
	    boolean esAscendente = true;  // Cambia a false si deseas orden descendente

	    // Establecer el orden ascendente o descendente según la variable esAscendente
	    clasificador.setSortsOnUpdates(true);
	    List<RowSorter.SortKey> clavesOrden = new ArrayList<>();
	    
	    if (esAscendente) {
	        clavesOrden.add(new RowSorter.SortKey(indiceColumna, SortOrder.ASCENDING));
	    } else {
	        clavesOrden.add(new RowSorter.SortKey(indiceColumna, SortOrder.DESCENDING));
	    }

	    clasificador.setSortKeys(clavesOrden);
	    clasificador.sort();  // Realizar el ordenamiento de la tabla
	}

}
