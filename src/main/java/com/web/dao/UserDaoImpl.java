package com.web.dao;

import java.util.List;


import javax.transaction.Transactional;


import org.hibernate.HibernateException;
import org.hibernate.Query;

import org.slf4j.*;
import org.slf4j.LoggerFactory;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.web.model.User;



@Repository("userDAO")
public class UserDaoImpl implements UserDAO {

	
	private static  final Logger log=LoggerFactory.getLogger(UserDaoImpl.class);
	@Autowired
	SessionFactory sessionFactory;

	// private Session session;
	// new line added by me
	public UserDaoImpl(SessionFactory sessionFactory) {
		try {
			log.debug("Inside SessionFactory constructor  ====");

			this.sessionFactory = sessionFactory;
		} catch (Exception e) {
			log.debug(e.toString());
		}
	}
	
	@Transactional
	public boolean save(User user) {
		try {
			log.debug("data is going to save=================");

			sessionFactory.openSession().save(user);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			log.debug(e.toString());
			return false;
		}
	}


	//------------------------working---------------
	@Transactional
	public List<User> list() {
		log.debug("View ALL Users==================");
		String hql = "from User";
		Query query = sessionFactory.openSession().createQuery(hql);
		return query.list();
	}

	@Transactional
	public User get(String id) {
		log.debug("Get Usser by ID============================");
		return (User) sessionFactory.openSession().get(User.class, id);
	}

	
	@Transactional
	public boolean update(User user) {
		try {
			log.debug("going to update data==========================");
			sessionFactory.openSession().save(user);
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Transactional
	public User validate(String id, String password) {
		log.debug("validate User by id and password ==================");	
String hql="from User where id='"+id+"' and password='"+password+"'";
Query query=sessionFactory.getCurrentSession().createQuery(hql);
return (User)query.uniqueResult();
	}

	
	
	/*
	 * // modify
	 * 
	 * @Transactional public boolean addUser(User obj) { try{
	 * sessionFactory.openSession().save(obj); System.out.println(
	 * "data is going to save"); return true;} catch(Exception e) {
	 * e.printStackTrace(); System.out.println(e); return false; }
	 * 
	 * }
	 * 
	 * 
	 * public List<User> viewALL() {
	 * 
	 * @SuppressWarnings("unchecked") List<User> list = (List<User>)
	 * sessionFactory.openSession().
	 * createCriteria(User.class).setResultTransformer(Criteria.
	 * DISTINCT_ROOT_ENTITY).list();
	 * 
	 * return list; }
	 * 
	 * 
	 * 
	 * public boolean updateUser(User user) { try { System.out.println(
	 * "going to update data"); sessionFactory.openSession().save(user); return
	 * true; } catch (HibernateException e) { // TODO Auto-generated catch block
	 * e.printStackTrace(); return false; }
	 * 
	 * } public void deleteUserById(String id) { System.out.print(
	 * "Going to delete"); User user = new User(); user.setUserId(id);
	 * sessionFactory.openSession().delete(user);
	 * 
	 * }
	 * 
	 * @Override public boolean isValidUserDetails(String id, String password) {
	 * System.out.println("Validating user"); String hql =
	 * "from User where id= '" + id + "' and " + " password ='" + password+"'";
	 * Query query = sessionFactory.openSession().createQuery(hql);
	 * 
	 * @SuppressWarnings("unchecked") List<User> list = (List<User>)
	 * query.list();
	 * 
	 * if (list != null && !list.isEmpty()) { return true; }
	 * 
	 * return false; } private User getUser(String hql) { System.out.println(
	 * "Calling getUser method"); Query query =
	 * sessionFactory.openSession().createQuery(hql);
	 * 
	 * @SuppressWarnings("unchecked") List<User> list = (List<User>)
	 * query.list(); if (list != null && !list.isEmpty()) { return list.get(0);
	 * } return null; }
	 * 
	 * @Override public User get(String id) { System.out.println(
	 * "Calling get method"); String hql = "from User where id=" + "'"+ id + "'"
	 * ; return getUser(hql); }
	 * 
	 * 
	 * @Override public User get(String id, String password) {
	 * System.out.println("Calling get method for id and password");
	 * 
	 * String hql = "from User where id=" + "'"+ id+"'  and password = " +"'" +
	 * password + "'"; return getUser(hql); }
	 * 
	 * //@Transactional //public boolean addUser(UserAdmin obj) { // try{ //
	 * sessionFactory.getCurrentSession().save(obj); // System.out.println(
	 * "UserAdmin data is going to save"); // return true;} // catch(Exception
	 * e) // { // e.printStackTrace(); // return false; // } // //}
	 * 
	 * 
	 */
}
