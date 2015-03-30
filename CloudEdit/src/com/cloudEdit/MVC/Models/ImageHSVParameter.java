package com.cloudEdit.MVC.Models;

public class ImageHSVParameter extends ImageParameter {

	private int _hue;
	private int _saturation;

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public String getHueName() {
		return ImageDefs.IMG_PARAM_NAME_HUE;
	}
	
	public String getSaturationName() {
		return ImageDefs.IMG_PARAM_NAME_SATURATION;
	}
	
	public int getHue() { return _hue; }
	public void setHue(int value) {
		this._hue = value;
	}
	
	public int getSaturation() { return _saturation; }
	public void setSaturation(int value) {
		this._saturation = value;
	}
}
