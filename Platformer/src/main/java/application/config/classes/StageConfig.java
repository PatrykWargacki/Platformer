package main.java.application.config.classes;

import javafx.stage.Stage;
import main.java.application.config.ConfigIO;

public class StageConfig {
	private Stage stage;
	
	public StageConfig(Stage stage){
		this.stage = stage;
	}
	
	public void init(){
		ConfigIO.load(stage);
	}
}
