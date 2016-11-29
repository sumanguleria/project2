package com.web.dao;
import java.util.*;

import com.web.model.Blog;

public interface BlogDAO {

	public List<Blog> list();

	
	public Blog get(String id);


	public boolean saveOrUpdate(Blog blog);

	public void delete(String id);
	


}
