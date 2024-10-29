package uiux.ejercicio03.panels;

import javax.swing.*;
import java.awt.*;
import net.miginfocom.swing.MigLayout;
import uiuc.models.Producto;
import uiux.ejercicio03.VentanaPrincipal;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PanelEliminarProducto extends JPanel {
	private static final long serialVersionUID = 1L;
	private JTextField txtNombreProducto;

	public PanelEliminarProducto() {
		setBackground(new Color(165, 42, 42));
		setLayout(new MigLayout("", "[][180px][][][][][grow][][][][][][][][][][][][][][][][][][][][]",
				"[25px][][][][][][][][][]"));

		JLabel label = new JLabel("Eliminar Producto");
		label.setFont(new Font("Tahoma", Font.BOLD, 20));
		add(label, "cell 12 0 4 1,grow");

		JLabel lblNewLabel = new JLabel("Nombre");
		add(lblNewLabel, "cell 7 3,alignx trailing");

		txtNombreProducto = new JTextField();
		add(txtNombreProducto, "cell 14 3,growx");
		txtNombreProducto.setColumns(10);

		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (validarCampos()) {
					if (eliminarProducto()) {
						JOptionPane.showMessageDialog(PanelEliminarProducto.this, "Producto eliminado con éxito.",
								"Éxito", JOptionPane.INFORMATION_MESSAGE);
						limpiarCampos();
					} else {
						JOptionPane.showMessageDialog(PanelEliminarProducto.this,
								"Producto no encontrado con el nombre proporcionado.", "Error",
								JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		});
		add(btnEliminar, "cell 16 6");
	}

	protected boolean eliminarProducto() {
		String nombre = txtNombreProducto.getText();

		Producto productoAEliminar = null;
		for (Producto pro : VentanaPrincipal.getListProductos()) {
			if (pro.getNombre().equalsIgnoreCase(nombre)) {
				productoAEliminar = pro;
				break;
			}
		}

		if (productoAEliminar != null) {
			VentanaPrincipal.getListProductos().remove(productoAEliminar);
			VentanaPrincipal.guardarProductos();
			return true;
		}
		return false;
	}

	private boolean validarCampos() {
		if (txtNombreProducto.getText().trim().isEmpty()) {
			JOptionPane.showMessageDialog(this, "No hay ningún dato introducido.", "Advertencia",
					JOptionPane.WARNING_MESSAGE);
			return false;
		}
		return true;
	}

	private void limpiarCampos() {
		txtNombreProducto.setText("");
	}
}
