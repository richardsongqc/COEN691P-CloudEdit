package com.cloudEdit.Service.ImageProc;

import java.io.IOException;
import java.io.InputStream;
import java.util.Hashtable;
import java.util.Map;
import java.util.Properties;

import com.cloudEdit.MVC.Models.*;
import com.cloudinary.Cloudinary;
import com.cloudinary.Transformation;

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
	
	public String upload(String url) {
		String publicId;
		Map<String, Object> result = new Hashtable<String, Object>();
		try {
			Map<String, Object> option = new Hashtable<String, Object>();
			result = cloudinary.uploader().upload(url, option);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		publicId = result.get("public_id").toString();
		String imgTag = cloudinary.url().imageTag(publicId);
		if(imgTag != null){
			
		}
		
		return publicId;
	}
	
	public String rotate(String id, ImageRotateParameter param) {
		String resultUrl = cloudinary.url().transformation(
				new Transformation().angle(param.get_angle()))
									.imageTag(id);
		return resultUrl;
	}
	
	public String scale(String id, ImageScaleParameter param) {
		String resultUrl = cloudinary.url().transformation(
				new Transformation().width(param.getWidth())
									.height(param.getHeight())
									.crop(param.getName()))
									.imageTag(id);
		return resultUrl;
	}
	
	public String applyContrast(String id, ImageContrastParameter param) {
		String resultUrl = cloudinary.url().transformation(
				new Transformation().effect(param.getName(), param.getRatio()))
									.imageTag(id);
		return resultUrl;
	}
	
	public String applyBrightness(String id, ImageBrightnessParameter param) {
		String resultUrl = cloudinary.url().transformation(
				new Transformation().effect(param.getName(), param.getLevel()))
									.imageTag(id);
		return resultUrl;
	}
	
	public String applySaturation(String id, ImageSaturationParameter param) {
		String resultUrl = cloudinary.url().transformation(
				new Transformation().effect(param.getName(), param.getLevel()))
									.imageTag(id);
		return resultUrl;
	}
	
}
