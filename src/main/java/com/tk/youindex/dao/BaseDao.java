package com.tk.youindex.dao;

import java.io.Serializable;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.tk.genericdao.dao.hibernate.GenericDAOImpl;

/**
 * BaseDao
 * 
 * @author Trim Kadriu <trim.kadriu@gmail.com>
 * @param <T>
 * @param <ID>
 */
public class BaseDao<T, ID extends Serializable> extends GenericDAOImpl<T, ID> {
	@Autowired
	@Override
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}
}
