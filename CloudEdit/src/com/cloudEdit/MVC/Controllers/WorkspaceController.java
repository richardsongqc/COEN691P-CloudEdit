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

import com.cloudEdit.MVC.Models.ImageRotateParameter;
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
	
	@RequestMapping(value = "/AutoAdjust", method = RequestMethod.GET)
	public @ResponseBody String autoAdjust(HttpServletRequest request, HttpServletResponse response) {
		int i = 0;
		i++;
		return "";
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
}
