package com.cloudEdit.Service.Authentication;

import facebook4j.Facebook;
import facebook4j.FacebookException;
import facebook4j.FacebookFactory;

public class FacebookOAuthService {

	private static FacebookOAuthService _instance;
	private static Facebook _facebook;
	
	protected FacebookOAuthService()
	{

	}
	
	public static FacebookOAuthService GetInstance() 
	{
		if(_instance == null){
			_instance = new FacebookOAuthService();
		}
		return _instance;
	}
	
	public Facebook GetFacebook()
	{
		if(_facebook == null){
			_facebook = new FacebookFactory().getInstance();
		}
		return _facebook;
	}
	
	public String GetOAuthAuthorizationURL(String callbackURL)
	{
		return GetFacebook().getOAuthAuthorizationURL(callbackURL);
	}
	
	public String GetOAuthAccessToken()
	{
		return GetFacebook().getOAuthAccessToken().getToken();
	}
	
	public String GetOAuthAccessToken(String oauthCode)
	{
		try {
			return GetFacebook().getOAuthAccessToken(oauthCode).getToken();
		} catch (FacebookException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "";
		}
	}
}
