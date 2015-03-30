package com.cloudEdit.MVC.Models;

public class ImageTextOverlayParameter extends ImageParameter {
	
	private static final String TEXT_PREFIX = "text:bold_dark";
	
	private String _text;
	private ImageGravityEnum _gravity;
	
	
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return TEXT_PREFIX + ":" + _text;
	}
	
	public String getText() { return _text; }
	public void setText(String value) {
		this._text = value.replace(' ', '+');
	}
	
	public ImageGravityEnum getGravity() { return _gravity; }
	public void setGravity(ImageGravityEnum value) {
		this._gravity = value;
	}
}
