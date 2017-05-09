package main.java.application.utils;

public class Resolution{
	private final double width;
	private final double height;
	
	public Resolution(double width, double height){
		this.width = width;
		this.height = height;
	}
	
	public double compare(Resolution that){
		return (this.width*this.height)
				- (that.width*that.height);
		
//		return (this.width-that.width) 
//				* (this.height-that.height);
	}
	
	public double getWidth() {
		return width;
	}

	public double getHeight() {
		return height;
	}

	@Override
	public String toString(){
		return (int) width 
			   + "x"
			   + (int) height;
	}
}