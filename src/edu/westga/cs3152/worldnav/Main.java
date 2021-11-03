package edu.westga.cs3152.worldnav;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * Entry point for the world navigation application
 * 
 * @author CS3152
 * @version Fall 2021
 */
public class Main extends Application {

	private static final String WINDOW_TITLE = "World Navigator";
	private static final String GUI_FXML = "view/WorldGui.fxml";

	@Override
	public void start(Stage primaryStage) {
		try {
			Pane pane = this.loadGui();
			Scene scene = new Scene(pane);
			primaryStage.setScene(scene);
			primaryStage.setTitle(WINDOW_TITLE);
			primaryStage.show();
		} catch (IllegalStateException | IOException anException) {
			anException.printStackTrace();
		}
	}

	private Pane loadGui() throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource(GUI_FXML));
		return (Pane) loader.load();
	}

	/**
	 * Launches the application
	 * 
	 * @pre none
	 * @post none
	 * 
	 * @param args not used
	 */
	public static void main(String[] args) {
		launch(args);
	}
}
