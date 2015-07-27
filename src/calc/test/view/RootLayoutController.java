package calc.test.view;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import calc.test.MainApp;

public class RootLayoutController {

	private MainApp mainApp;

	public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp;
	}

	@FXML
	private void handleAbout() {
		Alert alert = new Alert(AlertType.INFORMATION);
		Stage s = (Stage) alert.getDialogPane().getScene().getWindow();
		s.getIcons().add(
				new Image("file:resources/image/calculator-icon-vector.png"));
		alert.setTitle("Calculator");
		alert.setHeaderText("About");
		alert.setContentText("Just a JavaFX test, use the source code as you want.\n");

		alert.showAndWait();

	}

}
