package main.java.application.utils;

import java.util.Arrays;

public class SupportedResolution {
	private static final SupportedResolution instance = new SupportedResolution();
	private static final Resolution[] RESOLUTIONS = {new Resolution(3840,2160),
													 new Resolution(3200,2400),
													 new Resolution(3200,1800),
													 new Resolution(2560,1920),
													 new Resolution(2560,1440),
													 new Resolution(1920,1440),
													 new Resolution(1920,1080),
													 new Resolution(1600,1200),
													 new Resolution(1440,1080),
													 new Resolution(1280,960),
													 new Resolution(1280,720),
													 new Resolution(1024,768),
													 new Resolution(800,600),
													 new Resolution(640,480)
													 };
	
	public SupportedResolution(){
	}
	
	public static SupportedResolution getInstance(){
		return instance;
	}
	
	public static Resolution[] getSupportedResolutions(){
		return RESOLUTIONS;
	}
	
	public static Resolution[] getSupportedResolutions(final Resolution resolution){
		int i = 0;
		for(;i<RESOLUTIONS.length ;i++){
			if(resolution.compare(RESOLUTIONS[i])>=0){
				break;
			}
		}
		return Arrays.copyOfRange(RESOLUTIONS, i, RESOLUTIONS.length);
	}
}