package com.cloudEdit.MVC.Models;

public class ImageContrastParameter extends ImageParameter {

	private int ratio;
	
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return ImageDefs.IMG_PARAM_NAME_CONTRAST;
	}

	public int getRatio() { return ratio; }
	public void setRatio(int ratio) {
		this.ratio = ratio;
	}

}
