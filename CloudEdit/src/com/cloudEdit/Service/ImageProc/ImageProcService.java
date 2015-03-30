package com.cloudEdit.Service.ImageProc;

import java.io.IOException;
import java.io.InputStream;
import java.util.Hashtable;
import java.util.Map;
import java.util.Properties;

import com.cloudEdit.MVC.Models.*;
import com.cloudinary.Cloudinary;
import com.cloudinary.Transformation;
import com.google.gson.*;

public class ImageProcService {
	
	private static Cloudinary cloudinary;
	private static ImageProcService instance;
	
	protected ImageProcService() {
		initializeCloudinary();
	}
	
	@SuppressWarnings("deprecation")
	private void initializeCloudinary() {
		if(cloudinary == null) {
			
			Properties prop = new Properties();
			InputStream input = null;
			
			try {
				input = this.getClass().getClassLoader().getResourceAsStream("cloudinary4j.properties");
			}
			catch(NullPointerException e) {
				e.printStackTrace();
			}
			
			try {
				prop.load(input);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 
			cloudinary = new Cloudinary(Cloudinary.asMap(
					  "cloud_name", prop.getProperty("cloud_name"),
					  "api_key", prop.getProperty("api_key"),
					  "api_secret", prop.getProperty("api_secret")));
		}
	}
	
	public static ImageProcService getInstance() {
		if(instance == null) {
			instance = new ImageProcService();
		}
		return instance;
	}
	
	public Map<String, Object> upload(String url) {
		
		if(url.isEmpty())
			throw new IllegalArgumentException("Null url");
		
		Map<String, Object> result = new Hashtable<String, Object>();
		try {
			Map<String, Object> option = new Hashtable<String, Object>();
			result = cloudinary.uploader().upload(url, option);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}
	
	public String rotate(String id, ImageRotateParameter param) {
		String resultUrl = cloudinary.url().transformation(
				new Transformation().angle(param.get_angle())).generate(id);
		return resultUrl;
	}
	
	public String scale(String id, ImageScaleParameter param) {
		String resultUrl = cloudinary.url().transformation(
				new Transformation().width(param.getWidth())
									.height(param.getHeight())
									.crop(param.getName()))
									.generate(id);
		return resultUrl;
	}
	
	public String improve(String id) {
		String resultUrl = cloudinary.url().transformation(
				new Transformation().effect(ImageDefs.IMG_PARAM_NAME_IMPROVE)).generate(id);
		return resultUrl;
	}
	
	public String exposure(String id, ImageBrightnessParameter param, ImageContrastParameter param1) {
		String resultUrl = cloudinary.url().transformation(
				new Transformation().effect(param.getName(), param.getLevel())
				.chain().effect(param1.getName(), param1.getRatio()))
									.generate(id);
		return resultUrl;
	}
	
	public String HSV(String id, ImageHSVParameter param) {
		String resultUrl = cloudinary.url().transformation(
				new Transformation().effect(param.getHueName(), param.getHue()).
				chain().effect(param.getSaturationName(), param.getSaturation()))
				.generate(id);
		return resultUrl;
	}
	
	public String RGB(String id, ImageRGBParameter param) {
		String resultUrl = cloudinary.url().transformation(
				new Transformation().effect(param.getRedName(), param.getR()).
				chain().effect(param.getGreenName(), param.getG()).
				chain().effect(param.getBlueName(), param.getB())).generate(id);
		return resultUrl;
	}
	
	public String grayscale(String id) {
		String resultUrl = cloudinary.url().transformation(
				new Transformation().effect(ImageDefs.IMG_PARAM_NAME_GRAYSCALE)).generate(id);
		return resultUrl;
	}
	
	public String oilPaint(String id) {
		String resultUrl = cloudinary.url().transformation(
				new Transformation().effect(ImageDefs.IMG_PARAM_NAME_OILPAINT)).generate(id);
		return resultUrl;
	}
	
	public String negate(String id) {
		String resultUrl = cloudinary.url().transformation(
				new Transformation().effect(ImageDefs.IMG_PARAM_NAME_NEGATE)).generate(id);
		return resultUrl;
	}
	
	public String vignette(String id) {
		String resultUrl = cloudinary.url().transformation(
				new Transformation().effect(ImageDefs.IMG_PARAM_NAME_VIGNETTE)).generate(id);
		return resultUrl;
	}
	
	public String sepia(String id) {
		String resultUrl = cloudinary.url().transformation(
				new Transformation().effect(ImageDefs.IMG_PARAM_NAME_SEPIA)).generate(id);
		return resultUrl;
	}
	
	public String gradientFade(String id) {
		String resultUrl = cloudinary.url().transformation(
				new Transformation().effect(ImageDefs.IMG_PARAM_NAME_GRADIENTFADE)).generate(id);
		return resultUrl;
	}
	
	public String pixelate(String id, ImagePixelateParameter param) {
		String resultUrl = cloudinary.url().transformation(
				new Transformation().effect(param.getName(), param.getPixelation())).generate(id);
		return resultUrl;
	}
	
	public String blur(String id, ImageBlurParameter param) {
		String resultUrl = cloudinary.url().transformation(
				new Transformation().effect(param.getName(), param.getLevel())).generate(id);
		return resultUrl;
	}
	
	public String sharpen(String id, ImageSharpenParameter param) {
		String resultUrl = cloudinary.url().transformation(
				new Transformation().effect(param.getName(), param.getLevel())).generate(id);
		return resultUrl;
	}
	
	public String border(String id, ImageBorderParameter param) {
		String resultUrl = cloudinary.url().transformation(
				new Transformation().border(param.getPixel(), "#"+param.getHexColor())).generate(id);
		return resultUrl;
	}
	
	public String textOverlay(String id, ImageTextOverlayParameter param) {
		String resultUrl = cloudinary.url().transformation(
				new Transformation().overlay(param.getName()).x(8).y(8).gravity(param.getGravity().toString()))
				.generate(id);
		return resultUrl;
	}
}
