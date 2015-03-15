package com.cloudEdit.MVC.Models;

public class ImageRotateParameter extends ImageParameter {

	private int _angle;

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public int get_angle() { return _angle; }
	public void set_angle(int _angle) {
		this._angle = _angle;
	}

}
