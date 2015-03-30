package com.cloudEdit.MVC.Models;

import org.w3c.dom.css.RGBColor;

public class ImageRGBParameter extends ImageParameter {

	private int _r;
	private int _g;
	private int _b;

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public String getRedName() {
		return ImageDefs.IMG_PARAM_NAME_RED;
	}
	
	public String getGreenName() {
		return ImageDefs.IMG_PARAM_NAME_GREEN;
	}
	
	public String getBlueName() {
		return ImageDefs.IMG_PARAM_NAME_BLUE;
	}
	
	public int getR() { return _r; }
	public void setR(int value) {
		this._r = value;
	}
	
	public int getG() { return _g; }
	public void setG(int value) {
		this._g = value;
	}
	
	public int getB() { return _b; }
	public void setB(int value) {
		this._b = value;
	}
	
}
