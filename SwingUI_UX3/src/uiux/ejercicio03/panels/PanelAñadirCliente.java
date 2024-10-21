package uiux.ejercicio03.panels;

import javax.swing.*;
import java.awt.*;
import net.miginfocom.swing.MigLayout;
import com.toedter.calendar.JDateChooser;

public class PanelAñadirCliente extends JPanel {
    private static final long serialVersionUID = 1L;
    private JTextField textField;
    private JTextField textField_1;
    private JTextField textField_2;

    public PanelAñadirCliente() {
        Color colorFondo = Color.decode("#CC5803");
        setBackground(colorFondo);
        setLayout(new MigLayout("", "[][78px,grow][grow][][][][][][grow][][][][][]", "[13px][][][][][][][][][][][][][][][][][][grow][][][][][][][][][]"));
                                        
                                                JLabel label = new JLabel("Añadir Cliente");
                                                label.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 30));
                                                add(label, "cell 3 2");
                                
                                        JLabel lblNewLabel = new JLabel("Nombre");
                                        add(lblNewLabel, "cell 0 4,alignx trailing");
                                
                                        textField = new JTextField();
                                        add(textField, "cell 1 4 4 1,growx");
                                        textField.setColumns(10);
                                
                                        JLabel lblApellidos = new JLabel("Apellidos");
                                        add(lblApellidos, "cell 0 6,alignx trailing");
                                
                                        textField_1 = new JTextField();
                                        textField_1.setColumns(10);
                                        add(textField_1, "cell 1 6 3 1,growx");
                        
                                JLabel lblEmail = new JLabel("Email");
                                add(lblEmail, "cell 0 8,alignx trailing");
                
                        textField_2 = new JTextField();
                        textField_2.setColumns(10);
                        add(textField_2, "cell 1 8 3 1,growx");
                
                JLabel lblProvincia = new JLabel("Provincia");
                add(lblProvincia, "cell 0 10,alignx trailing");
                        
                        JComboBox comboBox = new JComboBox();
                        add(comboBox, "cell 1 10 3 1,growx");
                
                        JLabel lblEdad = new JLabel("Edad");
                        add(lblEdad, "cell 0 12,alignx trailing");
        
                JDateChooser dateChooser = new JDateChooser();
                dateChooser.setPreferredSize(new Dimension(150, 25)); // Establecer tamaño preferido
                add(dateChooser, "cell 1 12 3 1");
                
                JButton btnNewButton = new JButton("Añadir");
                add(btnNewButton, "cell 11 16");
    }
}
