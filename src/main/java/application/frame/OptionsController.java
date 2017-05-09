package main.java.application.frame;

import java.net.URL;
import java.util.ResourceBundle;

import com.sun.javafx.tk.Toolkit;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Rectangle2D;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.stage.Screen;
import main.java.application.config.ConfigIO;
import main.java.application.utils.Resolution;
import main.java.application.utils.SupportedResolution;

public class OptionsController implements Initializable{
	
	@FXML
	private ChoiceBox<Integer> screenBox;
	private ObservableList<Integer> screenByIntOL;
	private ObservableList<Screen> screenOL;
	private Screen primaryScreen;
	
	@FXML
	private ChoiceBox<String> resolutionBox;
	private ObservableList<String> resolutionByStringOL;
	private ObservableList<Resolution> resolutionOL;
	private Rectangle2D primaryResolution;
	
	@FXML
	private CheckBox fullscreenBox;
	private boolean fullscreen = false;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		ConfigIO.load(this);
		primaryScreen = Screen.getPrimary();
		
		/*
		 * need to take resolutions from hardware instead of describing it
		 * like in awt DeviceMode
		 * but i dont want to mix libraries
		*/
		primaryResolution = new Rectangle2D(600,400,0,0);
		fullscreenBox.setSelected(fullscreen);
		
		screenOL = Screen.getScreens();
		screenByIntOL = FXCollections.observableArrayList();
		resolutionOL = FXCollections.observableArrayList();
		resolutionByStringOL = FXCollections.observableArrayList();
		
		for(int i = 1; i <= screenOL.size(); i++){
			screenByIntOL.add(i); 
		}

		screenBox.setItems(screenByIntOL);
		screenBox.setValue(screenOL.indexOf(primaryScreen)+1);
		updateResolutionBox();
	}
	
	@FXML
	public void toggleFullscreen(){
		fullscreen = !fullscreen;
	}
	
	@FXML
	public void saveAction(){
		//primaryScreen = screenOL.get(screenBox.getValue());
		//primaryResolution = resolutionBox.getValue();
		// wywolaj zmiane wartosci okna (aspektowo)
	}
	
	@FXML
	public void cancelAction(){
		
	}
	
	@FXML
	public void updateResolutionBox(){
		resolutionByStringOL.clear();
		
		/*
		 * fill resolutionOL with resolution supported by screen
		 * right now only fullscreen 
		 */
		
		Rectangle2D r2D = screenOL.get(screenBox.getValue()-1)
			 	 				  .getBounds();
		resolutionOL = FXCollections.observableArrayList(SupportedResolution.getSupportedResolutions(new Resolution(r2D.getWidth(),
																   													r2D.getHeight())));
		for(Resolution r : resolutionOL){
			resolutionByStringOL.add(r.toString()); 
		}
		
		resolutionBox.setItems(resolutionByStringOL);
		resolutionBox.setValue(resolutionByStringOL.get(0));
	}
}
