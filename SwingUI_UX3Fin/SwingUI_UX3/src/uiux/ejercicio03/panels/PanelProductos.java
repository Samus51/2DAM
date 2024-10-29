package uiux.ejercicio03.panels;

import javax.swing.*;
import java.awt.*;
import net.miginfocom.swing.MigLayout;
import uiuc.models.Producto; // Asegúrate de que esta clase exista
import uiux.ejercicio03.VentanaPrincipal;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.RowFilter;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class PanelProductos extends JPanel {
    private static final long serialVersionUID = 1L;
    private JTable tableProductos;
    private JTextArea txtFiltro;
    private TableRowSorter<DefaultTableModel> sorter; // Agregada la variable sorter

    public PanelProductos() {
        setBackground(new Color(216, 191, 216));
        setLayout(new MigLayout("", "[90px][][grow][][grow][][][][][]", "[14px][][grow][][grow][][grow][][grow]"));

        JLabel label = new JLabel("Listado de Productos");
        label.setFont(new Font("Tahoma", Font.BOLD, 20));
        add(label, "cell 0 0,alignx left,aligny top");
        
        txtFiltro = new JTextArea(2, 30);
        txtFiltro.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                filtradoRow();
            }
        });
        add(txtFiltro, "cell 0 2,grow");

        JScrollPane scrollPane = new JScrollPane();
        add(scrollPane, "cell 0 4 9 1,grow");

        tableProductos = new JTable();
        DefaultTableModel model = new DefaultTableModel(
        	new Object[][] {
        		{null, null, null},
        		{null, null, null},
        		{null, null, null},
        		{null, null, null},
        		{null, null, null},
        		{null, null, null},
        		{null, null, null},
        		{null, null, null},
        		{null, null, null},
        		{null, null, null},
        	},
        	new String[] {
        		"Nombre", "Precio", "Perecedero"
        	}
        );
        
        tableProductos.setModel(model);
        
        // Crear el sorter y asignarlo a la tabla
        sorter = new TableRowSorter<>(model);
        tableProductos.setRowSorter(sorter);
        
        scrollPane.setViewportView(tableProductos);
        cargarProductosEnTabla();
    }

    private void cargarProductosEnTabla() {
        DefaultTableModel model = (DefaultTableModel) tableProductos.getModel();
        model.setRowCount(0); // Limpiar la tabla antes de cargar nuevos datos

        // Recorrer la lista de productos y agregarlos a la tabla
        for (Producto producto : VentanaPrincipal.getListProductos()) {
            model.addRow(new Object[]{
                producto.getNombre(),
                producto.getPrecioUnitario(),
                producto.isEsPerecedero(),
            });
        }
    }

    protected void filtradoRow() {
        RowFilter<DefaultTableModel, Integer> rowFilter = RowFilter.regexFilter(txtFiltro.getText(), 0);
        sorter.setRowFilter(rowFilter);
    }
}
