package com.cloudEdit.MVC.Models;

public class ImageBrightnessParameter extends ImageParameter {

	private int level;
	
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return ImageDefs.IMG_PARAM_NAME_BRIGHTNESS;
	}

	public int getLevel() { return level; }
	public void setLevel(int level) {
		this.level = level;
	}

}
