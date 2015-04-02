package com.cloudEdit.MVC.Controllers;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.cloudEdit.MVC.Models.DbAccount;
import com.cloudEdit.Service.Authentication.AuthenticationType;
import com.cloudEdit.Service.Authentication.FacebookOAuthService;
import com.cloudEdit.Service.Authentication.GoogleDatastoreAuthService;
import com.cloudEdit.Service.DataAccess.GoogleDatastoreDAO;
import com.cloudEdit.Service.DataAccess.GoogleDatastoreDAOImpl;

import facebook4j.Facebook;
import facebook4j.FacebookException;
import facebook4j.FacebookFactory;

@Controller
public class LoginController {

	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	public ModelAndView signup(HttpServletRequest request) throws ServletException {
		
		GoogleDatastoreAuthService svc = GoogleDatastoreAuthService.GetInstance();
		
		String email = request.getParameter("email");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		if(svc.accountExist(email))
			return new ModelAndView("signup");
		
		DbAccount account = new DbAccount();
		account.setEmail(email);
		account.setUserName(username);
		account.setPassword(password);
		
		svc.signup(account);
		
		request.getSession().setAttribute("isAuthenticated", true);
		request.getSession().setAttribute("authType", AuthenticationType.database);
		request.getSession().setAttribute("username", account.getUserName());
		
		request.setAttribute("page", "workspace.jsp");
		return new ModelAndView("layout");
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login(HttpServletRequest request) throws ServletException {
		
		GoogleDatastoreAuthService svc = GoogleDatastoreAuthService.GetInstance();
		
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		DbAccount account = svc.signin(email, password);
		
		if(account == null)
			return new ModelAndView("signin");
		
		request.getSession().setAttribute("isAuthenticated", true);
		request.getSession().setAttribute("authType", AuthenticationType.database);
		request.getSession().setAttribute("username", account.getUserName());
		
		request.setAttribute("page", "workspace.jsp");
		return new ModelAndView("layout");
	}
	
	@RequestMapping(value = "/login_fb", method = RequestMethod.GET)
	public String loginFacebook(HttpServletRequest request) {
		
        // prepare callback URL
        StringBuffer callbackURL = request.getRequestURL();
        int index = callbackURL.lastIndexOf("/");
        callbackURL.replace(index, callbackURL.length(), "").append("/login_callback");
        
        String authorizationURL = FacebookOAuthService.GetInstance().GetOAuthAuthorizationURL(callbackURL.toString());
        
        // redirect
		return "redirect:" + authorizationURL;
	}
	
	@RequestMapping(value = "/login_callback", method = RequestMethod.GET)
	public ModelAndView LoignFacebook_Callback(HttpServletRequest request) throws ServletException, IllegalStateException, FacebookException
	{
        String oauthCode = request.getParameter("code");
		FacebookOAuthService.GetInstance().GetOAuthAccessToken(oauthCode);
		Facebook facebook = FacebookOAuthService.GetInstance().GetFacebook();
        
		request.getSession().setAttribute("isAuthenticated", true);
		request.getSession().setAttribute("authType", AuthenticationType.facebook);
		request.getSession().setAttribute("username", facebook.getName());
		
        request.setAttribute("page", "workspace.jsp");
		return new ModelAndView("layout");
	}
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String LogoutFacebook(HttpServletRequest request) throws ServletException
	{
		AuthenticationType authType = (AuthenticationType)request.getSession().getAttribute("authType");
		
		if(authType == AuthenticationType.facebook) {
	        String accessToken = FacebookOAuthService.GetInstance().GetOAuthAccessToken();
	        request.getSession().invalidate();
	
	        // Log Out of the Facebook
	        StringBuffer next = request.getRequestURL();
	        int index = next.lastIndexOf("/");
	        next.replace(index+1, next.length(), "index.jsp");
	        	        
	        return "redirect:" + "http://www.facebook.com/logout.php?next=" + next.toString() + "&access_token=" + accessToken;
		}
		
		return "redirect:" + "index.jsp";
	}
}
