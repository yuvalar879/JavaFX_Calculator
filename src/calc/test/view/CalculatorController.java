package calc.test.view;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import calc.test.MainApp;
import calc.test.model.Calculator;

public class CalculatorController {

	@FXML
	private Button b1;
	@FXML
	private TextArea t1;
	@FXML
	private Button C;
	@FXML
	private Button plus;
	@FXML
	private Button Minus;
	@FXML
	private Button Displayans;
	@FXML
	private Button multiply;
	@FXML
	private Button slash;
	@FXML
	private Button sqrt;
	@FXML
	private Button invSign;
	@FXML
	private Button del;
	@FXML
	private TextField t2;
	@FXML
	private Button bpoint;

	private String setCSS;

	private static Integer ans = 0;

	private String currentOperation;

	private int x;

	private MainApp mainApp;

	Calculator cal = new Calculator();

	public CalculatorController() {

	}

	@FXML
	private void initialize() {

		C.setOnAction((event) -> {
			t1.setText(cal.Clear());
			t2.setText("Ans");
		});

		del.setOnAction((event) -> {
			try {
				String s = t1.getText();
				s = s.substring(0, s.length() - 1);
				t1.setText(s);
			} catch (Exception e) {

			}
		});

		// ///Can also be done this way
		String css = MainApp.class.getResource("view/Design.css")
				.toExternalForm();
		b1.getStylesheets().add(css);

		t2.setStyle("-fx-focus-color: transparent;");

	}

	@FXML
	private void HandleDigit(ActionEvent e) {
		t1.appendText(((Button) e.getSource()).getText());

	}

	@FXML
	private void Invert() {
		try {
			String y = t1.getText();
			x = Integer.parseInt(y) * -1;
			y = Integer.toString(x);
			t1.setText(y);
		} catch (Exception e) {

		}
	}

	@FXML
	private void handleEqualOperation(ActionEvent event) {
		int newNumber = Integer.parseInt(t1.getText());
		switch (currentOperation) {
		case "+":
			ans += newNumber;
			break;
		case "-":
			ans -= newNumber;
			break;
		case "*":
			ans *= newNumber;
			break;
		case "/":
			ans /= newNumber;
		default:
			break;
		}
		t2.setText("Ans                 " + ans);
		t1.appendText("");
	}

	@FXML
	private void handleOperation(ActionEvent event) {
		ans = Integer.parseInt(t1.getText());
		t1.setText("");
		currentOperation = ((Button) event.getSource()).getText();
	}

	@FXML
	private void sqrt() {
		double temp = (double) ans;
		temp = Math.sqrt(temp);
		t2.setText("Ans " + "            " + temp);
	}

	public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp;
	}

}
