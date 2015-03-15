package com.cloudEdit.Service.DataAccess;

import com.cloudEdit.MVC1.Models.DbAccount;
import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.EntityNotFoundException;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;

public class GoogleDatastoreDAOImpl implements GoogleDatastoreDAO {

	private static String ENTITY_NAME_ACCOUNT = "Account";
	
	private static String PROPERTY_NAME_USRNAME = "username";
	private static String PROPERTY_NAME_PWD = "password";
	private static String PROPERTY_NAME_EMAIL = "email";
	
	private static GoogleDatastoreDAOImpl instance;
	protected GoogleDatastoreDAOImpl() {
	}
	
	public GoogleDatastoreDAOImpl getInstance() {
		if(instance == null) {
			instance = new GoogleDatastoreDAOImpl();
		}
		return instance;
	}

	@Override
	public boolean createAccount(DbAccount account) {
		DatastoreService ds = DatastoreServiceFactory.getDatastoreService();
		Entity entity = new Entity(ENTITY_NAME_ACCOUNT, account.getEmail());
		entity.setProperty(PROPERTY_NAME_USRNAME, account.getUserName());
		entity.setProperty(PROPERTY_NAME_PWD, account.getPassword());
		ds.put(entity);
		
		return true;
	}

	@Override
	public DbAccount findAccount(String id) {
		DbAccount account = new DbAccount();
		DatastoreService ds = DatastoreServiceFactory.getDatastoreService();
		Entity entity = null;
		
		Key key = KeyFactory.stringToKey(id);
		try {
			entity = ds.get(key);
		} catch (EntityNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
		account.setEmail(entity.getProperty(PROPERTY_NAME_EMAIL).toString());
		account.setUserName(entity.getProperty(PROPERTY_NAME_USRNAME).toString());
		account.setPassword(entity.getProperty(PROPERTY_NAME_PWD).toString());
		
		return account;
	}

	@Override
	public boolean updateAccount(DbAccount account) {
		DatastoreService ds = DatastoreServiceFactory.getDatastoreService();
		Entity entity = null;
		
		Key key = KeyFactory.stringToKey(account.getEmail());
		try {
			entity = ds.get(key);
		} catch (EntityNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
		entity.setProperty(PROPERTY_NAME_USRNAME, account.getUserName());
		entity.setProperty(PROPERTY_NAME_PWD, account.getPassword());
		
		return true;
	}

	@Override
	public boolean deleteAccount(String id) {
		DatastoreService ds = DatastoreServiceFactory.getDatastoreService();
		Key key = KeyFactory.stringToKey(id);
		ds.delete(key);
		return true;
	}
}
