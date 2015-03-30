package com.cloudEdit.MVC.Models;

public class ImageBorderParameter extends ImageParameter {

	private int _pixel;
	private String _hexColor;
	
	
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public int getPixel() { return _pixel; }
	public void setPixel(int value) {
		this._pixel = value;
	}
	
	
	public String getHexColor() { return _hexColor; }
	public void setHexColor(String value) {
		this._hexColor = value;
	}
	
}
