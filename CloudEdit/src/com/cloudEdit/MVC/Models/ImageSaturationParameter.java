package com.cloudEdit.MVC.Models;

public class ImageSaturationParameter extends ImageParameter {

	private int level;
	
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return ImageDefs.IMG_PARAM_NAME_SATURATION;
	}

	public int getLevel() { return level; }
	public void setLevel(int level) {
		this.level = level;
	}

}
