package edu.sjsu.cmpe275.lab2.controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import edu.sjsu.cmpe275.lab2.entity.AddressEntity;
import edu.sjsu.cmpe275.lab2.entity.PhoneEntity;
import edu.sjsu.cmpe275.lab2.entity.UserEntity;
import edu.sjsu.cmpe275.lab2.service.UserSerivceImpl;

@Controller
public class UserController {
	@Autowired
	UserSerivceImpl uService;
	
	/*@Autowired
	PhoneService pService;*/
	
	@RequestMapping(value = "/user")
	public String showAllUsers() {
		uService.userCreation();
		return "welcome";
	}
}