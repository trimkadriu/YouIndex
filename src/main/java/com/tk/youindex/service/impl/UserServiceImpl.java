package com.tk.youindex.service.impl;

import com.tk.youindex.dao.spec.UserDao;
import com.tk.youindex.domain.User;
import com.tk.youindex.service.spec.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * Created by t.kadriu.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public String createOrUpdateUser(User user) {
        userDao.save(user);
        return "true";
    }

}
