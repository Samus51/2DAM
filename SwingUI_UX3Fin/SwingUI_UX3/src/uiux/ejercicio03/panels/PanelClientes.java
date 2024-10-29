package uiux.ejercicio03.panels;

import javax.swing.*;
import java.awt.*;
import net.miginfocom.swing.MigLayout;
import uiuc.models.Cliente;
import uiux.ejercicio03.VentanaPrincipal;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.RowFilter;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class PanelClientes extends JPanel {
    private static final long serialVersionUID = 1L;
    private JTable tableClientes;
    private JTextField txtFiltro; // Cambiado a JTextField
    private TableRowSorter<DefaultTableModel> sorter; // Agregada la variable sorter

    public PanelClientes() {
        setBackground(new Color(216, 191, 216));
        setLayout(new MigLayout("", "[90px][][][][grow][][]", "[14px][][grow][][grow]"));
        
        JLabel label = new JLabel("Listado de Clientes");
        label.setFont(new Font("Tahoma", Font.BOLD, 20));
        add(label, "cell 0 0,alignx left,aligny top");

        txtFiltro = new JTextField(); // Cambiado a JTextField
        txtFiltro.setBorder(BorderFactory.createTitledBorder("Filtrar por Nombre")); // Agregar borde
        txtFiltro.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                filtradoRow();
            }
        });
        add(txtFiltro, "cell 4 2 2 1,grow");

        JScrollPane scrollPane = new JScrollPane();
        add(scrollPane, "cell 0 4 7 1,grow");

        tableClientes = new JTable();
        DefaultTableModel model = new DefaultTableModel(
                new Object[][] { { null, null, null, null, null }, { null, null, null, null, null },
                        { null, null, null, null, null }, { null, null, null, null, null },
                        { null, null, null, null, null }, { null, null, null, null, null },
                        { null, null, null, null, null }, { null, null, null, null, null }, },
                new String[] { "Nombre", "Apellidos", "Edad", "Email", "Provincia" });

        tableClientes.setModel(model);
        
        // Crear el sorter y asignarlo a la tabla
        sorter = new TableRowSorter<>(model);
        tableClientes.setRowSorter(sorter);
        
        // Ajustar columnas
        tableClientes.getColumnModel().getColumn(0).setPreferredWidth(150);
        tableClientes.getColumnModel().getColumn(1).setPreferredWidth(150);
        tableClientes.getColumnModel().getColumn(2).setPreferredWidth(50);
        tableClientes.getColumnModel().getColumn(3).setPreferredWidth(200);
        tableClientes.getColumnModel().getColumn(4).setPreferredWidth(100);
        
        // Agregar borde a la tabla
        tableClientes.setBorder(BorderFactory.createEtchedBorder());
        scrollPane.setViewportView(tableClientes);
        
        cargarClientesEnTabla();
    }

    private void cargarClientesEnTabla() {
        DefaultTableModel model = (DefaultTableModel) tableClientes.getModel();
        // Limpiar la tabla antes de cargar nuevos datos
        model.setRowCount(0);

        // Recorrer la lista de clientes y agregarlos a la tabla
        for (Cliente cliente : VentanaPrincipal.getListClientes()) {
            model.addRow(new Object[] {
                cliente.getNombre(), 
                cliente.getApellidos(), 
                cliente.getEdad(),  // Asegúrate de tener un método getEdad() en la clase Cliente
                cliente.getEmail(), 
                cliente.getProvincia()
            });
        }
    }

    protected void filtradoRow() {
        RowFilter<DefaultTableModel, Integer> rowFilter = RowFilter.regexFilter(txtFiltro.getText(), 0);
        sorter.setRowFilter(rowFilter);
    }
}
