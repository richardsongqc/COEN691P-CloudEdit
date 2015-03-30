package com.cloudEdit.MVC.Models;

public class ImagePixelateParameter extends ImageParameter {
	
	private int _pixelation;

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return ImageDefs.IMG_PARAM_NAME_PIXELATE;
	}
	
	public int getPixelation() { return _pixelation; }
	public void setPixelation(int value) {
		this._pixelation = value;
	}

}
