package com.cloudEdit.Service.DataAccess;

import com.cloudEdit.MVC.Models.DbAccount;

public interface GoogleDatastoreDAO {
	public boolean createAccount(DbAccount account);
	public DbAccount findAccount(String id);
	public boolean updateAccount(DbAccount account);
	public boolean deleteAccount(String id);
}
