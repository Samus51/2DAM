package uiux.ejercicio03;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class MainApp {

    public static void main(String[] args) {
        // Establecer el look and feel de Nimbus
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }

        VentanaPrincipal pantalla = new VentanaPrincipal();
        pantalla.setVisible(true);
    }
}
