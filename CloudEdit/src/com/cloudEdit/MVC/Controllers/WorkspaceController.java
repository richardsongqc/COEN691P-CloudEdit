package com.cloudEdit.MVC.Controllers;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.cloudEdit.Service.ImageProc.ImageProcService;

@Controller
public class WorkspaceController {

	@RequestMapping(value = "/upload", method = RequestMethod.GET)
	public @ResponseBody String upload(HttpServletRequest request, HttpServletResponse response) {
		String src = request.getParameter("src");
		ImageProcService.getInstance().upload(src);
		return "";
	}
	
	@RequestMapping(value = "/AutoAdjust", method = RequestMethod.GET)
	public @ResponseBody String autoAdjust(HttpServletRequest request, HttpServletResponse response) {
		int i = 0;
		i++;
		return "";
	}
	
	@RequestMapping(value = "/rotate", method = RequestMethod.GET)
	public @ResponseBody String rotate(HttpServletRequest request, HttpServletResponse response) {
		String src = request.getParameter("src");
		int angle = Integer.parseInt(request.getParameter("angle"));
		ImageProcService.getInstance().upload(src);
		return "";
	}
}
