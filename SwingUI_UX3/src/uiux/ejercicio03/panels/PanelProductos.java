package uiux.ejercicio03.panels;

import javax.swing.*;
import java.awt.*;

public class PanelProductos extends JPanel {
    public PanelProductos() {
        setBackground(Color.YELLOW);
        setLayout(null); // Puedes usar MigLayout u otro si prefieres
        JButton btnNewButton = new JButton("Boton Cambiado");
        btnNewButton.setBounds(242, 144, 89, 23);
        add(btnNewButton);
        
        JLabel label = new JLabel("Listado de Productos");
        label.setBounds(242, 11, 100, 14);
        add(label);
    }
}
