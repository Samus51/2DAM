package combos;

import javax.swing.DefaultComboBoxModel;

import models.Reparacion;

public class MetodosComboBox {

	/**
	 * Coge el model del comboBox, limpia el cb y busca en la lista de objetos segun
	 * especificaciones , aqui le ponemos String para solo poner la "Matricula del vehiculo" por ejemplo y
	 * lo añadimos al modelo
	 */
	
	private void cargaReparaciones() {
        DefaultComboBoxModel<String> model = (DefaultComboBoxModel<String>) cbMatricula.getModel();
        model.removeAllElements(); // Limpiar el modelo antes de agregar nuevas matrículas
        for (Reparacion rep : main.Launcher.lstReparaciones) {
            String matricula = rep.getCita().getVehiculo().getMatricula();
            // Solo añadir reparaciones que NO están finalizadas
            if (!"Finalizado".equals(rep.getEstado())) {
                model.addElement(matricula);
            }
        }
    }
/**
 * Para cargar datos del objeto a labels, tenemos que tener un objeto default en la clase
 * para luego buscar en la lista segun en el ComboBox y pasarlo al nuestro y ya pasarlo a los labels
 */
    private void actualizarDatos() {
        String matriculaSeleccionada = (String) cbMatricula.getSelectedItem();
        if (matriculaSeleccionada == null) return;

        for (Reparacion rep : main.Launcher.lstReparaciones) {
            if (rep.getCita().getVehiculo().getMatricula().equals(matriculaSeleccionada)) {
                reparacionSeleccionada = rep;
                break;
            }
        }

        if (reparacionSeleccionada != null) {
            lblMarca.setText(reparacionSeleccionada.getCita().getVehiculo().getMarca());
            lblModelo.setText(reparacionSeleccionada.getCita().getVehiculo().getModelo());
            lblEstadoActual.setText(reparacionSeleccionada.getEstado());

            // Primero, eliminar los elementos existentes en el combo
            cbNuevoEstado.removeAllItems();

            // Ahora, añadir los nuevos elementos según el estado
            if ("Pendiente".equals(reparacionSeleccionada.getEstado())) {
                cbNuevoEstado.addItem("En curso");
            } else if ("En curso".equals(reparacionSeleccionada.getEstado())) {
                cbNuevoEstado.addItem("Finalizado");
            }

            // Esto es para mantener la selección de la matrícula
            cbMatricula.setSelectedItem(matriculaSeleccionada);

            // Verifica si el panel oculto debe ser visible
            verificarPanelOculto();
        }
    }

	
	
	
}
