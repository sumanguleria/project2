package com.web.dao;

import java.util.List;

import com.web.model.Chat;

public interface ChatDAO {

	public List<Chat> list();
	public Chat get(int id);
    public boolean saveOrUpdate(Chat chat);
    public void delete(int id);
	

}
