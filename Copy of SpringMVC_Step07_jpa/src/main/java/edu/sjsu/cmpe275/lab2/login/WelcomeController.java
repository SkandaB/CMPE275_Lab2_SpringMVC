package edu.sjsu.cmpe275.lab2.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class WelcomeController {
	@Autowired
	LoginService loginService;// = new LoginService();
	
	@RequestMapping(value="/login", method = RequestMethod.GET)
	public String showLogin(){
		return "login";
	}
	@RequestMapping(value="/login", method = RequestMethod.POST)
	public String handleLogin(@RequestParam String name,@RequestParam String password,ModelMap model){
		if(!loginService.validateUser(name, password)){
			model.put("errorMessage", "invalid username or password");
			return "login";
		}
		model.put("name", name);
		return "welcome";
	}

}
