package com.cloudEdit.MVC.Controllers;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.cloudEdit.MVC.Models.*;
import com.cloudEdit.Service.ImageProc.ImageProcService;
import com.google.gson.*;

@Controller
public class WorkspaceController {

	@RequestMapping(value = "/upload", method = RequestMethod.GET)
	public @ResponseBody String upload(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		// upload
		String src = request.getParameter("src");
		Map<String, Object> resp = ImageProcService.getInstance().upload(src);
		
		// save the public id
		request.getSession().setAttribute("current_id", resp.get("public_id"));
		return new Gson().toJson(resp);
	}
	
	@RequestMapping(value = "/improve", method = RequestMethod.GET)
	public @ResponseBody String autoAdjust(HttpServletRequest request, HttpServletResponse response) {
		
		// operation
		String id = request.getSession().getAttribute("current_id").toString();
		String resultUrl = ImageProcService.getInstance().improve(id);
		
		if(resultUrl == null)
			return "";
		
		// upload
		Map<String, Object> resp = ImageProcService.getInstance().upload(resultUrl);
		
		// save the public id
		request.getSession().setAttribute("current_id", resp.get("public_id"));
		return new Gson().toJson(resp);
	}
	
	@RequestMapping(value = "/rotate", method = RequestMethod.GET)
	public @ResponseBody String rotate(HttpServletRequest request, HttpServletResponse response) {
		
		// prepare the parameter
		int angle = Integer.parseInt(request.getParameter("angle"));
		ImageRotateParameter param = new ImageRotateParameter();
		param.set_angle(angle);
		
		// operation
		String id = request.getSession().getAttribute("current_id").toString();
		String resultUrl = ImageProcService.getInstance().rotate(id, param);
		
		// upload
		Map<String, Object> resp = ImageProcService.getInstance().upload(resultUrl);
		
		// save the public id
		request.getSession().setAttribute("current_id", resp.get("public_id"));
		return new Gson().toJson(resp);
	}
	
	@RequestMapping(value = "/resize", method = RequestMethod.GET)
	public @ResponseBody String resize(HttpServletRequest request, HttpServletResponse response) {
		// prepare the parameter
		int width = Integer.parseInt(request.getParameter("width"));
		int height = Integer.parseInt(request.getParameter("height"));
		
		ImageScaleParameter param = new ImageScaleParameter();
		param.setWidth(width);
		param.setHeight(height);
		
		// operation
		String id = request.getSession().getAttribute("current_id").toString();
		String resultUrl = ImageProcService.getInstance().scale(id, param);
		
		// upload
		Map<String, Object> resp = ImageProcService.getInstance().upload(resultUrl);
		
		// save the public id
		request.getSession().setAttribute("current_id", resp.get("public_id"));
		return new Gson().toJson(resp);		
	}
	
	@RequestMapping(value = "/exposure", method = RequestMethod.GET)
	public @ResponseBody String exposure(HttpServletRequest request, HttpServletResponse response) {
		// prepare the parameter
		int brightness = Integer.parseInt(request.getParameter("brightness"));
		int contrast = Integer.parseInt(request.getParameter("contrast"));
		
		ImageBrightnessParameter param = new ImageBrightnessParameter();
		param.setLevel(brightness);
		
		ImageContrastParameter param1 = new ImageContrastParameter();
		param1.setRatio(contrast);
		
		// operation
		String id = request.getSession().getAttribute("current_id").toString();
		String resultUrl = ImageProcService.getInstance().exposure(id, param, param1);
		
		// upload
		Map<String, Object> resp = ImageProcService.getInstance().upload(resultUrl);
		
		// save the public id
		request.getSession().setAttribute("current_id", resp.get("public_id"));
		return new Gson().toJson(resp);
	}
	
	@RequestMapping(value = "/color", method = RequestMethod.GET)
	public @ResponseBody String color(HttpServletRequest request, HttpServletResponse response) {
		// prepare the parameter
		int r = Integer.parseInt(request.getParameter("r"));
		int g = Integer.parseInt(request.getParameter("g"));
		int b = Integer.parseInt(request.getParameter("b"));
		
		ImageRGBParameter param = new ImageRGBParameter();
		param.setR(r);
		param.setG(g);
		param.setB(b);
		
		// operation
		String id = request.getSession().getAttribute("current_id").toString();
		String resultUrl = ImageProcService.getInstance().RGB(id, param);
		
		// upload
		Map<String, Object> resp = ImageProcService.getInstance().upload(resultUrl);
		
		// save the public id
		request.getSession().setAttribute("current_id", resp.get("public_id"));
		return new Gson().toJson(resp);
	}
	
	@RequestMapping(value = "/hsv", method = RequestMethod.GET)
	public @ResponseBody String hsv(HttpServletRequest request, HttpServletResponse response) {
		// prepare the parameter
		int saturation = Integer.parseInt(request.getParameter("saturation"));
		int hue = Integer.parseInt(request.getParameter("hue"));
		
		ImageHSVParameter param = new ImageHSVParameter();
		param.setSaturation(saturation);
		param.setHue(hue);
		
		// operation
		String id = request.getSession().getAttribute("current_id").toString();
		String resultUrl = ImageProcService.getInstance().HSV(id, param);
		
		// upload
		Map<String, Object> resp = ImageProcService.getInstance().upload(resultUrl);
		
		// save the public id
		request.getSession().setAttribute("current_id", resp.get("public_id"));
		return new Gson().toJson(resp);
	}
	
	@RequestMapping(value = "/effects", method = RequestMethod.GET)
	public @ResponseBody String applyEffect(HttpServletRequest request, HttpServletResponse response) {
		
		// operation
		String id = request.getSession().getAttribute("current_id").toString();
		String type = request.getParameter("type");
		
		String resultUrl = null;
		switch(type) {
		case ImageDefs.IMG_PARAM_NAME_GRAYSCALE:
			resultUrl = ImageProcService.getInstance().grayscale(id);
			break;
		case ImageDefs.IMG_PARAM_NAME_NEGATE:
			resultUrl = ImageProcService.getInstance().negate(id);
			break;
		case ImageDefs.IMG_PARAM_NAME_VIGNETTE:
			resultUrl = ImageProcService.getInstance().vignette(id);
			break;
		case ImageDefs.IMG_PARAM_NAME_OILPAINT:
			resultUrl = ImageProcService.getInstance().oilPaint(id);
			break;
		case ImageDefs.IMG_PARAM_NAME_GRADIENTFADE:
			resultUrl = ImageProcService.getInstance().gradientFade(id);
			break;
		case ImageDefs.IMG_PARAM_NAME_SEPIA:
			resultUrl = ImageProcService.getInstance().sepia(id);
			break;
		case ImageDefs.IMG_PARAM_NAME_PIXELATE:
			int pxielation = Integer.parseInt(request.getParameter("pixelation"));
			ImagePixelateParameter param = new ImagePixelateParameter();
			param.setPixelation(pxielation);
			resultUrl = ImageProcService.getInstance().pixelate(id, param);
			break;
		case ImageDefs.IMG_PARAM_NAME_BLUR:
			int level_blur = Integer.parseInt(request.getParameter("level"));
			ImageBlurParameter param1 = new ImageBlurParameter();
			param1.setLevel(level_blur);
			resultUrl = ImageProcService.getInstance().blur(id, param1);
			break;
		case ImageDefs.IMG_PARAM_NAME_SHARPEN:
			int level_sharpen = Integer.parseInt(request.getParameter("level"));
			ImageSharpenParameter param2 = new ImageSharpenParameter();
			param2.setLevel(level_sharpen);
			resultUrl = ImageProcService.getInstance().sharpen(id, param2);
			break;
		default:
			break;
		}
		
		// upload
		Map<String, Object> resp = ImageProcService.getInstance().upload(resultUrl);
		
		// save the public id
		request.getSession().setAttribute("current_id", resp.get("public_id"));
		return new Gson().toJson(resp);
	}
	
	@RequestMapping(value = "/border", method = RequestMethod.GET)
	public @ResponseBody String border(HttpServletRequest request, HttpServletResponse response) {
		
		// prepare the parameter
		int pixel = Integer.parseInt(request.getParameter("pixel"));
		String color = request.getParameter("color");
		
		ImageBorderParameter param = new ImageBorderParameter();
		param.setPixel(pixel);
		param.setHexColor(color);
		
		// operation
		String id = request.getSession().getAttribute("current_id").toString();
		String resultUrl = ImageProcService.getInstance().border(id, param);
		
		// upload
		Map<String, Object> resp = ImageProcService.getInstance().upload(resultUrl);
		
		// save the public id
		request.getSession().setAttribute("current_id", resp.get("public_id"));
		return new Gson().toJson(resp);
	}
	
	@RequestMapping(value = "/textoverlay", method = RequestMethod.GET)
	public @ResponseBody String textOverlay(HttpServletRequest request, HttpServletResponse response) {
		// prepare the parameter
		String text = request.getParameter("text");
		String position = request.getParameter("position");
		
		ImageTextOverlayParameter param = new ImageTextOverlayParameter();
		param.setText(text);
		
		ImageGravityEnum gravity;
		switch(position) {
		case "top":
			gravity = ImageGravityEnum.north;
			break;
		case "top-left":
			gravity = ImageGravityEnum.north_west;
			break;
		case "top-right":
			gravity = ImageGravityEnum.north_east;
			break;
		case "bottom":
			gravity = ImageGravityEnum.south;
			break;
		case "bottom-left":
			gravity = ImageGravityEnum.south_west;
			break;
		case "bottom-right":
			gravity = ImageGravityEnum.south_east;
			break;
		default:
			gravity = ImageGravityEnum.south;
			break;
		}
		param.setGravity(gravity);
		
		// operation
		String id = request.getSession().getAttribute("current_id").toString();
		String resultUrl = ImageProcService.getInstance().textOverlay(id, param);
		
		// upload
		Map<String, Object> resp = ImageProcService.getInstance().upload(resultUrl);
		
		// save the public id
		request.getSession().setAttribute("current_id", resp.get("public_id"));
		return new Gson().toJson(resp);
	}
}
