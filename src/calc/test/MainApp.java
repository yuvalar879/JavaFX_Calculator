package calc.test;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import calc.test.view.CalculatorController;
import calc.test.view.RootLayoutController;



public class MainApp extends Application {
	
	private Stage primaryStage;
	private BorderPane rootLayout;
	
	@Override
	public void start(Stage primaryStage) {
		this.primaryStage=primaryStage;
		this.primaryStage.setTitle("Calculator");
		
		this.primaryStage.getIcons().add(new Image("file:resources/image/calculator-icon-vector.png"));
		
		initRootLayout();
		
		showCalc();
	}
	
	public void initRootLayout() {
		try {
			FXMLLoader loader=new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("view/RootLayout.fxml"));
			rootLayout=(BorderPane) loader.load();
			
			Scene scene=new Scene(rootLayout);
			primaryStage.setScene(scene);
			
			RootLayoutController controller=loader.getController();
			controller.setMainApp(this);
			
			primaryStage.show();
			
		} catch (IOException e) {
			e.printStackTrace();
			
		}
		
	}
	
	public void showCalc() {
		try {
			FXMLLoader loader=new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("view/Calculator.fxml"));
			 AnchorPane ShowCalc = (AnchorPane) loader.load();
			
			rootLayout.setCenter(ShowCalc);
			
			CalculatorController controller=loader.getController();
			controller.setMainApp(this);
				
		} catch (IOException e) {
			e.printStackTrace();
			
		}
		
	}
	
	public Stage getPrimaryStage() {
		return primaryStage;
	}
	
	
	public static void main(String[] args) {
		launch(args);
	}
}


