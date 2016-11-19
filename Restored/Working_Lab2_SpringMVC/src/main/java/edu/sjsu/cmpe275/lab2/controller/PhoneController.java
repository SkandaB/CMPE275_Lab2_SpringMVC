package edu.sjsu.cmpe275.lab2.controller;

import java.util.List;

import javax.persistence.Embeddable;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import edu.sjsu.cmpe275.lab2.entity.AddressEntity;
import edu.sjsu.cmpe275.lab2.entity.PhoneEntity;
import edu.sjsu.cmpe275.lab2.entity.UserEntity;
import edu.sjsu.cmpe275.lab2.service.PhoneService;
import edu.sjsu.cmpe275.lab2.service.UserSerivce;
import edu.sjsu.cmpe275.lab2.validator.PhoneFormValidator;


/**
 * @author SkandaBhargav
 * Controller class to handle the various inbounds requests
 */
@Controller
public class PhoneController {
	@Autowired
	private PhoneService pService;
	
	@Autowired
	private UserSerivce uService;

	@RequestMapping(value = "/phone", method = RequestMethod.GET)
	public ModelAndView showPhoneCreationForm(){
		ModelAndView modelAndView = new ModelAndView("phones/addPhone");
		return modelAndView;
	}

	@RequestMapping(value="/phone", method=RequestMethod.POST)
	public void phoneCreation(
			@RequestParam String number,
			@RequestParam String description,
			@RequestParam String city,
			@RequestParam String state,
			@RequestParam String street,
			@RequestParam String zip_code,
			ModelMap model,
			HttpServletRequest  request,
			HttpServletResponse  response) {
		PhoneEntity pEntity = pService.createUser(number,description,city,state,street,zip_code);
		String redirect = "http://localhost:8080/phone/"+pEntity.getId().toString();
		try{
			response.sendRedirect(redirect);
		}catch (Exception e) {
			// TODO: handle exception
		}
	}

	@RequestMapping(value = "/phone/{pid}", method = RequestMethod.GET)
	public Object showPhone(@RequestParam(value="json", required = false, defaultValue="false") String json,
							@PathVariable("pid") int id) {
		PhoneEntity pEntity = pService.findById(id);
		List<UserEntity> users = uService.findAll();
		if(json.equals("true")) {
			System.out.println("Data in JSON ****************");
			ModelAndView mv = new ModelAndView(new MappingJackson2JsonView());
			mv.addObject(pEntity);
			return mv;
		} 
		System.out.println(" **************** Returning the normal model view ****************");
		ModelAndView mv = new ModelAndView("phones/phoneInfo");
		mv.addObject("phones", pEntity);
		mv.addObject("users",users);
		return mv;
	}

	@RequestMapping(value = "/phone/{pid}", method = RequestMethod.DELETE)
	public ModelAndView deleteUser(@PathVariable("pid") int id, Model model){
		boolean status = pService.deleteById(id);

		System.out.println("Came back after deleting the phone");
		if(status){
			return new ModelAndView("http://localhost:8080/phone");
		}else{			
			return new ModelAndView("welcome");
		}
	}

	@RequestMapping(value="/phone/{pid}", method = RequestMethod.POST)
	public String updatePhone(@PathVariable("pid") Integer id,
			@RequestParam String number,
			@RequestParam String description,
			@RequestParam String city,
			@RequestParam String state,
			@RequestParam String street,
			@RequestParam String zip_code,
			ModelMap model,
			HttpServletRequest  request,
			HttpServletResponse  response ) {
		PhoneEntity pEntity = pService.updatePhone((Integer)id,number,description,city,state,street,zip_code);

		/*ModelAndView modelAndView = new ModelAndView("users/userInfo");
		modelAndView.addObject("user", uEntity);
		return modelAndView;*/
		return "httlp://localhost:8080/user/"+pEntity.getId().toString();

	}

}

/*if (phoneService == null) {
	model.addAttribute("css", "danger");
	model.addAttribute("msg", "Phone not found");
}*/