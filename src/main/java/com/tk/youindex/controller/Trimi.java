package com.tk.youindex.controller;

import com.tk.youindex.dao.spec.UserDao;
import com.tk.youindex.domain.User;
import com.tk.youindex.domain.enums.Status;
import com.tk.youindex.service.spec.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;

@Controller
@RequestMapping(value = "web")
public class Trimi {

    @Autowired
    UserService userService;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView index() {
        Date today = new Date();

        User user = new User();
        user.setId("12390");
        user.setActivationHash("asdasda");
        user.setAdminUser(true);
        user.setDateAdded(new Date());
        user.setEmail("mymail@trimi.com");
        user.setLastLogin(new Date());
        user.setName("Trim");
        user.setPassword("asldka");
        user.setPasswordSalt("asd");
        user.setStatus(Status.OK);

        userService.createUser(user);
        return new ModelAndView("trimi").addObject("today", today.toString());
    }

}
