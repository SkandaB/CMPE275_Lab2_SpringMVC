package edu.sjsu.cmpe275.lab2.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import edu.sjsu.cmpe275.lab2.entity.UserEntity;
import edu.sjsu.cmpe275.lab2.service.UserSerivce;

/**
 * @author SkandaBhargav
 *
 */
@Controller
public class UserController {
	@Autowired
	UserSerivce uService;

	/**
	 * @return
	 */
	@RequestMapping(value = "/user", method = RequestMethod.GET)
	public ModelAndView showUserCreationForm(){
		ModelAndView modelAndView = new ModelAndView("users/addUser");
		return modelAndView;
	}

	/**
	 * @param firstname
	 * @param lastname
	 * @param title
	 * @param city
	 * @param state
	 * @param street
	 * @param zip
	 * @param model
	 * @param request
	 * @param response
	 */
	@RequestMapping(value = "/user", method = RequestMethod.POST)
	public Object userCreating(@RequestParam String firstname, 
			@RequestParam String lastname, 
			@RequestParam String title, 
			@RequestParam String city, 
			@RequestParam String state, 
			@RequestParam String street, 
			@RequestParam String zip_code,
			ModelMap model,
			HttpServletRequest request,
			HttpServletResponse response) {
		ModelAndView mv = new ModelAndView("users/addUser");
		if(firstname.isEmpty() || lastname.isEmpty() || title.isEmpty() || city.isEmpty() ||
		state.isEmpty() || street.isEmpty() || zip_code.isEmpty()){
		mv.addObject("errorMessage", "* Please enter all the missing values");
		return mv;
		}
		if(zip_code.length()!=5){
		mv.addObject("errorMessage", "* Zip Code invalid");
		return mv;
		}
		UserEntity uEntity = uService.createUser(firstname,lastname,title,city,state,street,zip_code);

		/*String redr = "redirect:/user/"+uEntity.getId();
		return new ModelAndView(new RedirectView(redr));
*/
	/*	ModelAndView mv = new ModelAndView("users/userInfo");
		mv.addObject("user", uEntity);
		return mv;*/

		String redirect = "http://104.198.234.6/lab2-1.0/user/"+uEntity.getId().toString();
		try{
			response.sendRedirect(redirect);
		}catch (Exception e) {
		}
		return null;
	}

	/**
	 * @param json
	 * @param id
	 * @return
	 * @throws JsonGenerationException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	@SuppressWarnings("unused")
	@RequestMapping(value="/user/{uid}", method = RequestMethod.GET)
	public Object showUser(@RequestParam(value="json",required = false, defaultValue="false") String json, 
			@PathVariable("uid") int id,
			final HttpServletResponse response) throws JsonGenerationException, JsonMappingException, IOException {
		UserEntity uEntity = uService.findById(id);

		if(null != uEntity)
		{
			System.out.println("**************Value of Json = "+ json);
			System.out.println("Returned from find = " + uEntity.toString());

			if(json.equals("true")) {
				System.out.println("Data in JSON ****************");
				ModelAndView mv = new ModelAndView(new MappingJackson2JsonView());
				response.setStatus(HttpStatus.OK.value());
				mv.addObject(uEntity);
				return mv;
			} 
			System.out.println(" **************** Returning the normal model view ****************");
			ModelAndView mv = new ModelAndView("users/userInfo");
			response.setStatus(HttpStatus.OK.value());
			mv.addObject("user", uEntity);
			return mv;
		}
		else{
			ModelAndView modelAndView = new ModelAndView("error");
			String noUser = "User " +id + " Not found";
			response.setStatus(HttpStatus.NOT_FOUND.value());
			modelAndView.addObject("errorMessage", noUser);
			modelAndView.addObject("responseCode", HttpStatus.NOT_FOUND.value());
			
			return modelAndView;
		}
	}

	/**
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/user/{uid}", method = RequestMethod.DELETE)
	public ModelAndView deleteUser(@PathVariable("uid") int id, ModelMap model) {
		boolean status = uService.deleteById(id);

		System.out.println("Came back after deleting the user");
		if(status){
			return new ModelAndView("http://localhost:8080/user");
		}else{			
			return new ModelAndView("welcome");
		}
	}	

	/**
	 * @param id
	 * @param firstname
	 * @param lastname
	 * @param title
	 * @param city
	 * @param state
	 * @param street
	 * @param zip_code
	 * @param model
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/user/{uid}", method = RequestMethod.POST)
	public String updateUser(@PathVariable("uid") int id,
			@RequestParam String firstname, 
			@RequestParam String lastname, 
			@RequestParam String title, 
			@RequestParam String city, 
			@RequestParam String state, 
			@RequestParam String street, 
			@RequestParam String zip_code,
			ModelMap model,
			HttpServletRequest request,
			HttpServletResponse response) {
		UserEntity uEntity = uService.updateUser((Integer)id,firstname,lastname,title,city,state,street,zip_code);
		System.out.println("*********** From controller, the object returned = "+ uEntity.toString());

		/*ModelAndView modelAndView = new ModelAndView("users/userInfo");
		modelAndView.addObject("user", uEntity);
		return modelAndView;*/
		return "http://104.198.234.6/lab2-1.0/user/"+uEntity.getId().toString();

	}
}

