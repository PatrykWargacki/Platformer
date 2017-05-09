package main.java.application.frame;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import main.java.application.config.ConfigIO;
import main.java.application.config.classes.SpriteLogic;

public class GameController implements Initializable{
	
	@FXML
	private Canvas background;
	private SpriteLogic[] backgroundSprite;
	
	@FXML
	private Canvas game;
	private SpriteLogic[] gameSprite;
	
	@FXML
	private Canvas frontground;
	private SpriteLogic[] frontgroundSprite;
	
	@FXML
	private Canvas user;
	private SpriteLogic[] userSprite;
	
	@FXML
	private Canvas effects;
	private SpriteLogic[] effectsSprite;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		ConfigIO.load(background	, "background");
		ConfigIO.load(game			, "game");
		ConfigIO.load(frontground	, "frontground");
		ConfigIO.load(user			, "user");
		ConfigIO.load(effects		, "effects");
	}
	
	private void paintBackground(){
		GraphicsContext graphicsContext = background.getGraphicsContext2D();
		for(SpriteLogic spriteLogic : backgroundSprite){
			paint(graphicsContext, spriteLogic);
		}
	}
	
	private void paintGame(){
		GraphicsContext graphicsContext = game.getGraphicsContext2D();
		for(SpriteLogic spriteLogic : gameSprite){
			paint(graphicsContext, spriteLogic);
		}
	}
	
	private void paintFrontground(){
		GraphicsContext graphicsContext = frontground.getGraphicsContext2D();
		for(SpriteLogic spriteLogic : frontgroundSprite){
			paint(graphicsContext, spriteLogic);
		}
	}
	
	private void paintUser(){
		GraphicsContext graphicsContext = user.getGraphicsContext2D();
		for(SpriteLogic spriteLogic : userSprite){
			paint(graphicsContext, spriteLogic);
		}
	}
	
	private void paintEffects(){
		GraphicsContext graphicsContext = effects.getGraphicsContext2D();
		for(SpriteLogic spriteLogic : effectsSprite){
			paint(graphicsContext, spriteLogic);
		}
		
	}
	
	public void paintAll(){
		paintBackground();
		paintGame();
		paintFrontground();
		paintUser();
		paintEffects();
	}
	
	private void paint(GraphicsContext graphicsContext, SpriteLogic spriteLogic){
		graphicsContext.drawImage(spriteLogic.getImg(), 
								  spriteLogic.getX(), 
								  spriteLogic.getY(), 
								  spriteLogic.getWidth(), 
								  spriteLogic.getHeight());
	}
	
}
