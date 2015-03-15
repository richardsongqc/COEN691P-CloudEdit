package com.cloudEdit.MVC1.Models;

public class ImageScaleParameter extends ImageParameter {

	private int width, height;
	
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return ImageDefs.IMG_PARAM_NAME_SCALE;
	}
	
	public int getWidth() { return width; }
	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() { return height; }
	public void setHeight(int height) {
		this.height = height;
	}

}
