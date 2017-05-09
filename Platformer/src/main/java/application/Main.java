package main.java.application;
	
import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import main.java.application.config.ConfigIO;


public class Main extends Application {
	private Stage primaryStage;
	private AnchorPane rootLayout;
	
	@Override
	public void start(Stage primaryStage) {
		this.primaryStage = primaryStage;
		
		initLayout();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
	public void initLayout(){
		try{
			/*
			 * Load scene from Canvas.fxml
			 */
			FXMLLoader fxmlLoader = new FXMLLoader();
			fxmlLoader.setLocation(Main.class.getResource("frame/view/Options.fxml"));
			rootLayout = fxmlLoader.load();
			
			ConfigIO.load(primaryStage);
			
			/*
			 * Show the scene
			 */
			Scene scene = new Scene(rootLayout);
			primaryStage.setScene(scene);
			primaryStage.show();
		}catch (IOException e){
			e.printStackTrace();
		}
	}
	
}
