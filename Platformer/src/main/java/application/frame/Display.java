package main.java.application.frame;

import java.awt.DisplayMode;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.util.HashSet;
import java.util.Set;

public class Display {
	private GraphicsDevice graphicsDevice = GraphicsEnvironment
												.getLocalGraphicsEnvironment()
												.getDefaultScreenDevice();
	private DisplayMode displayMode = graphicsDevice
										.getDisplayMode();
	
	public Display(DisplayMode displayMode, GraphicsDevice graphicsDevice){
		this.graphicsDevice = graphicsDevice;
		this.displayMode 	= displayMode;
	}
	
	public static GraphicsDevice[] getGraphicsDevices(){
		return GraphicsEnvironment
				.getLocalGraphicsEnvironment()
				.getScreenDevices();
	}
	
	public static Display[] getDisplayModes(){
		Set<Display> displaySet = new HashSet<Display>();
		GraphicsDevice[] graphicsDevices = getGraphicsDevices();
		DisplayMode[] displayModes;
		Display display;
		
		for(GraphicsDevice gd : graphicsDevices){
			displayModes =  gd.getDisplayModes();
			
			for(DisplayMode dm : displayModes){
				display = new Display(dm, gd);
				displaySet.add(display);
			}
		}
		
		return displaySet.toArray(
				new Display[displaySet.size()]);
	}
	
	public void setFullscreen(){
		if(graphicsDevice.isFullScreenSupported()){
			graphicsDevice.setFullScreenWindow(null);
		}
	}

	public GraphicsDevice getGraphicsDevice() {
		return graphicsDevice;
	}

	public DisplayMode getDisplayMode() {
		return displayMode;
	}

	public void setGraphicsDevice(GraphicsDevice graphicsDevice) {
		this.graphicsDevice = graphicsDevice;
	}

	public void setDisplayMode(DisplayMode displayMode) {
		this.displayMode = displayMode;
	}

}
