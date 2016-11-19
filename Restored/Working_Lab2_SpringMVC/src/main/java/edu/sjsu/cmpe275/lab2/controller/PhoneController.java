package edu.sjsu.cmpe275.lab2.controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import edu.sjsu.cmpe275.lab2.entity.AddressEntity;
import edu.sjsu.cmpe275.lab2.entity.PhoneEntity;
import edu.sjsu.cmpe275.lab2.entity.UserEntity;
import edu.sjsu.cmpe275.lab2.service.PhoneService;
import edu.sjsu.cmpe275.lab2.validator.PhoneFormValidator;


/**
 * @author SkandaBhargav
 * Controller class to handle the various inbounds requests
 */
@Controller
public class PhoneController {
	@Autowired
	private PhoneService phoneService;

	/*@Autowired
	PhoneFormValidator phoneFormValidator;*/


	/**
	 * This controller method redirects the users from default home page to Welcome page
	 * @param model sets the attributes in the model to be used by the views
	 * @return view name which will be resolved to a .jsp page
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index(Model model) {
		return "redirect:/welcome";
	}

	/**
	 * This controller method will show the list of available phones
	 * @param model sets the attributes in the model to be used by the views
	 * @return view name which will be resolved to a .jsp page
	 */
	@RequestMapping(value = "/phones", method = RequestMethod.GET)
	public String showAllPhones(Model model) {
		model.addAttribute("phones", phoneService.findAll());
		return "phones/list";
	}


	/**
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/phone/{id}", method = RequestMethod.GET)
	public String showUser(@PathVariable("id") int id, Model model) {
		PhoneEntity pEntity = phoneService.findById(id);
		if (phoneService == null) {
			model.addAttribute("css", "danger");
			model.addAttribute("msg", "Phone not found");
		}
		model.addAttribute("phone", pEntity);
		return "phones/show";
	}

	@RequestMapping(value="/phonejson/{id}", method = RequestMethod.GET)
	public @ResponseBody PhoneEntity getPhoneEntityInJSON(@PathVariable("id") int id,
			@RequestParam String json,
			Model model) {
		PhoneEntity pEntity = phoneService.findById(id);
		if (phoneService == null) {
			model.addAttribute("css", "danger");
			model.addAttribute("msg", "Phone not found");
		}

		return pEntity;
	}

}
