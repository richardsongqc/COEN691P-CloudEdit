package com.cloudEdit.Service.Authentication;

import java.net.MalformedURLException;
import java.net.URL;

import facebook4j.Facebook;
import facebook4j.FacebookException;
import facebook4j.FacebookFactory;
import facebook4j.PostUpdate;
import facebook4j.PrivacyBuilder;
import facebook4j.PrivacyParameter;
import facebook4j.PrivacyType;

public class FacebookOAuthService {

	private static FacebookOAuthService _instance;
	private static Facebook _facebook;
	
	protected FacebookOAuthService() {
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
