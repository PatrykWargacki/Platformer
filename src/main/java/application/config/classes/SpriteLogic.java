package main.java.application.config.classes;

import javafx.scene.image.Image;

public class SpriteLogic {
	private double x;
	private double y;
	private double width;
	private double height;
	private Image img;
	
	public double getX() {
		return x;
	}
	public double getY() {
		return y;
	}
	public double getWidth() {
		return width;
	}
	public double getHeight() {
		return height;
	}
	public Image getImg() {
		return img;
	}
	public void setX(double x) {
		this.x = x;
	}
	public void setY(double y) {
		this.y = y;
	}
	public void setWidth(double width) {
		this.width = width;
	}
	public void setHeight(double height) {
		this.height = height;
	}
	public void setImg(Image img) {
		this.img = img;
	}
}
