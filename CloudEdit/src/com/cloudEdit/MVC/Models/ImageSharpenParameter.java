package com.cloudEdit.MVC.Models;

public class ImageSharpenParameter extends ImageParameter {

	private int _level;

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return ImageDefs.IMG_PARAM_NAME_SHARPEN;
	}
	
	public int getLevel() { return _level; }
	public void setLevel(int value) {
		this._level = value;
	}
	
}
