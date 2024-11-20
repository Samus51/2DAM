package mainApp;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        try {
            // Cargar el archivo FXML
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/VentanaPrincipal.fxml"));
            BorderPane root = loader.load(); 

            Scene scene = new Scene(root, 800, 600);

            // Cargar la hoja de estilos
            scene.getStylesheets().add(getClass().getResource("/styles.css").toExternalForm());

            // Establecer la escena y mostrar la ventana
            primaryStage.setTitle("MyGames");
            primaryStage.setScene(scene);
            primaryStage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args); 
    }
}
