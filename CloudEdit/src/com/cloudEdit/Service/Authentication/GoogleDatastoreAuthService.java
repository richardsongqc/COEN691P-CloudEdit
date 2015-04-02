package com.cloudEdit.Service.Authentication;

import com.cloudEdit.MVC.Models.*;
import com.cloudEdit.Service.DataAccess.GoogleDatastoreDAO;
import com.cloudEdit.Service.DataAccess.GoogleDatastoreDAOImpl;

public class GoogleDatastoreAuthService {

	private static GoogleDatastoreAuthService _instance;
	
	public static GoogleDatastoreAuthService GetInstance() 
	{
		if(_instance == null){
			_instance = new GoogleDatastoreAuthService();
		}
		return _instance;
	}
	
	public boolean signup(DbAccount account) {
		if(account == null)
			return false;
		
		if(accountExist(account.getEmail()))
			return false;
		
		boolean result = GoogleDatastoreDAOImpl.getInstance().createAccount(account);
		
		return result;
	}
	
	public DbAccount signin(String email, String password) {
		
		if(email == null || password == null)
			return null;
		
		GoogleDatastoreDAO dao = GoogleDatastoreDAOImpl.getInstance();
		DbAccount acc = dao.getAccountByEmail(email);
		if(acc == null)
			return null;
		
		if(!password.equals(acc.getPassword()))
			return null;
		
		return acc;
	}
	
	public boolean signout() {
		 return true;
	}
	
	public boolean accountExist(String email) {
		GoogleDatastoreDAO dao = GoogleDatastoreDAOImpl.getInstance();
		return dao.getAccountByEmail(email) != null;
	}
}
