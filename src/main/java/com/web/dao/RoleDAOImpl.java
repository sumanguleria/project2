package com.web.dao;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SessionFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.web.model.*;

@Repository("roleDAO")
public class RoleDAOImpl implements RoleDAO{


    @Autowired(required = true)
	private SessionFactory sessionFactory;

	public RoleDAOImpl(SessionFactory sessionFactory) {
		try {
			this.sessionFactory = sessionFactory;
		} catch (Exception e) {


			e.printStackTrace();
		}
	}

	@Transactional
	public List<Role> list() {
		String hql = "from Role";

		Query query = sessionFactory.getCurrentSession().createQuery(hql);

		@SuppressWarnings("unchecked")
		List<Role> list = (List<Role>) query.list();

		return list;
	}

	@Transactional
	public boolean saveOrUpdate(Role role) {

		try {
			sessionFactory.getCurrentSession().saveOrUpdate(role);
			return true;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

	}


	@Transactional
	public void delete(String id) {
		Role role = new Role();
		role.setId(id);
		sessionFactory.getCurrentSession().delete(role);
	}

	@Transactional
	public Role get(String id) {
		String hql = "from Role where id=" + "'" + id + "'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);

		List<Role> list = (List<Role>) query.list();

		if (list != null && !list.isEmpty()) {
			return list.get(0);
		}
		return null;

	}

}
