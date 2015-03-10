package com.cloudEdit.Service.Authentication;

import facebook4j.Facebook;
import facebook4j.FacebookException;
import facebook4j.FacebookFactory;

public class FacebookOAuthService {

	private static FacebookOAuthService _instance;
	private static Facebook _facebook;
	
	protected FacebookOAuthService()
	{
		if(_facebook == null){
			_facebook = new FacebookFactory().getInstance();
		}
	}
	
	public static FacebookOAuthService GetInstance() 
	{
		if(_instance == null){
			_instance = new FacebookOAuthService();
		}
		return _instance;
	}
	
	public Facebook GetFacebookInstance()
	{
		return _facebook;
	}
	
	public String GetOAuthAuthorizationURL(String callbackURL)
	{
		return _facebook.getOAuthAuthorizationURL(callbackURL);
	}
	
	public String GetOAuthAccessToken(String oauthCode)
	{
		try {
			return _facebook.getOAuthAccessToken(oauthCode).getToken();
		} catch (FacebookException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "";
		}
	}
}
