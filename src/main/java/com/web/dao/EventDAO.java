package com.web.dao;
import java.util.*;

import com.web.model.Event;


public interface EventDAO {


	public List<Event> list();

	
	public Event get(String id);


	public boolean saveOrUpdate(Event event);

	public void delete(String id);
	

}
