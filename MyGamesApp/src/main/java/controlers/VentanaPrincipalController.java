package controlers;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

public class VentanaPrincipalController implements Initializable {

  @FXML
  private BorderPane VentanaPrincipal;

  @FXML
  private Button btnLogin;

  @FXML
  private ImageView imgLogo;

  @FXML
  private ImageView imgOjo;

  @FXML
  private Label lblPassword;

  @FXML
  private Label lblRegistro;

  @FXML
  private Label lblUser;

  @FXML
  private BorderPane panelLogo;

  @FXML
  private PasswordField passwordText;

  @FXML
  private TextField txtPasswordClear;

  @FXML
  private TextField txtUser;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		Image img = new Image(getClass().getResourceAsStream("/Logo.png"));
		imgLogo.setImage(img);
		
	}
}
