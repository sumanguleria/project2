package com.web.dao;
import java.util.List;

import com.web.model.*;
public interface RoleDAO {



	public List<Role> list();
	public Role get(String id);
    public boolean saveOrUpdate(Role role);
    public void delete(String id);
	


}
