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
import edu.sjsu.cmpe275.lab2.service.PhoneService;
import edu.sjsu.cmpe275.lab2.validator.PhoneFormValidator;


@Controller
public class PhoneController {
	@Autowired
	private PhoneService phoneService;
	
	/*@Autowired
	PhoneFormValidator phoneFormValidator;*/
	
	@RequestMapping(value = "/phones", method = RequestMethod.GET)
	public String showAllPhones(Model model) {
		model.addAttribute("phones", phoneService.findAll());
		return "phones/list";
	}
	
}
