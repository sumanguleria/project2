package com.web.dao;

import java.util.List;

import com.web.model.UserRole;

public interface UserRoleDAO {

public List<UserRole> list();
	
	public UserRole get(String id);

	public boolean saveOrUpdate(UserRole userRole);

	public void delete(String userID, String roleID);

}
