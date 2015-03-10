package com.cloudEdit.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cloudEdit.Service.Authentication.FacebookOAuthService;

import facebook4j.Facebook;
import facebook4j.FacebookException;
import facebook4j.FacebookFactory;

@Controller
public class LoginController {

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String Login(HttpServletRequest request) {
		Facebook facebook = new FacebookFactory().getInstance();
        request.getSession().setAttribute("facebook", facebook);
        StringBuffer callbackURL = request.getRequestURL();
        int index = callbackURL.lastIndexOf("/");
        callbackURL.replace(index, callbackURL.length(), "").append("/login_callback");
        String authorizationURL = facebook.getOAuthAuthorizationURL(callbackURL.toString());
		return "redirect:" + authorizationURL;
	}
	
	@RequestMapping(value = "/login_callback", method = RequestMethod.GET)
	public String LoignCallback(HttpServletRequest request) throws ServletException
	{
        Facebook facebook = (Facebook) request.getSession().getAttribute("facebook");
        String oauthCode = request.getParameter("code");
        try {
            facebook.getOAuthAccessToken(oauthCode);
        } catch (FacebookException e) {
            throw new ServletException(e);
        }
        
        String contextPath = request.getContextPath() + "index";
        return contextPath;
	}
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String Logout(HttpServletRequest request) throws ServletException
	{
        Facebook facebook = (Facebook) request.getSession().getAttribute("facebook");
        String accessToken = "";
        try {
        	accessToken = facebook.getOAuthAccessToken().getToken();
        } catch (Exception e) {
            throw new ServletException(e);
        }
        request.getSession().invalidate();

        // Log Out of the Facebook
        StringBuffer next = request.getRequestURL();
        int index = next.lastIndexOf("/");
        next.replace(index+1, next.length(), "index.jsp");
        
        return "redirect:" + "http://www.facebook.com/logout.php?next=" + next.toString() + "&access_token=" + accessToken;
	}
}
