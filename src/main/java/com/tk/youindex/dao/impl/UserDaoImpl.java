package com.tk.youindex.dao.impl;

import com.tk.youindex.dao.spec.UserDao;
import com.tk.youindex.domain.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

/**
 * Created by t.kadriu.
 */
@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public String createUser(User user) {
        Serializable id = sessionFactory.getCurrentSession().save(user);
        return (String)id;
    }

}
