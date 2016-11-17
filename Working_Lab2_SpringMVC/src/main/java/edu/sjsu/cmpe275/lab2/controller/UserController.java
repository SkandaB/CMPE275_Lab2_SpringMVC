package edu.sjsu.cmpe275.lab2.Controller;

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
import org.springframework.web.servlet.ModelAndView;

import edu.sjsu.cmpe275.lab2.Entity.Address;
import edu.sjsu.cmpe275.lab2.Entity.Phone;
import edu.sjsu.cmpe275.lab2.Entity.User;


@Controller

public class UserController {
	//@Autowired private UserService userService;

	
	@RequestMapping(value="/user", method = RequestMethod.GET)
	public ModelAndView showUserCreationForm(){
		
		ModelAndView modelAndView = new ModelAndView("addUser");
		return modelAndView;
	}
	
	
	@RequestMapping(value="/user", method = RequestMethod.POST)
	public void userCreating(@RequestParam String firstname,@RequestParam String lastname,@RequestParam String title,
			@RequestParam String city,@RequestParam String state,@RequestParam String street,@RequestParam String zip_code,ModelMap model,
			HttpServletRequest  request,HttpServletResponse  response){
		
		
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory( "Assignment2_2756" );

		EntityManager entitymanager = emfactory.createEntityManager( );
		entitymanager.getTransaction( ).begin( );


		User user = new User(); 
		
		user.setFirstname(firstname);
		user.setLastname(lastname);
		user.setTitle(title);
		
		Address addr = new Address();
		addr.setCity(city);
		addr.setState(state);
		addr.setStreet(street);
		addr.setZip(zip_code);
		user.setAddress(addr);
		entitymanager.persist(user );
		entitymanager.getTransaction( ).commit( );

		entitymanager.close( );
		emfactory.close( );
		
		String uid = user.getId();
		
		
		String redirect = "http://localhost:8080/user/"+uid;
		try{
			response.sendRedirect(redirect);
			
		}catch(Exception e){
			
		}
		

		/*ModelAndView mv = new ModelAndView("userInfo");
		mv.addObject("user", user);
		
		return mv;*/
	}
	
	@RequestMapping(value="/user/{uid}", method = RequestMethod.GET)
	public ModelAndView afterUserCreationForm(@PathVariable String uid){
		
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory( "Assignment2_2756" );

		EntityManager entitymanager = emfactory.createEntityManager( );
		entitymanager.getTransaction( ).begin( );
		
		User user = entitymanager.find(User.class, uid);
		entitymanager.getTransaction( ).commit( );
		
		ModelAndView mv = new ModelAndView("userInfo");
		mv.addObject("user", user);
		
		return mv;
	}
	
	@RequestMapping(value="/user/{uid}", method = RequestMethod.DELETE)
	public ModelAndView deleteUser(@PathVariable String uid){
		
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory( "Assignment2_2756" );

		EntityManager entitymanager = emfactory.createEntityManager( );
		entitymanager.getTransaction( ).begin( );
		User user = entitymanager.find(User.class, uid);
		entitymanager.remove(user);
		
		entitymanager.getTransaction( ).commit( );
		
		System.out.println("here");
		ModelAndView mv = new ModelAndView("addUser");
	
		
		return mv;
		

	}
	
	@RequestMapping(value="/user/{uid}",method = RequestMethod.POST)
	public void updateUser(@PathVariable String uid,@RequestParam String firstname,@RequestParam String lastname,@RequestParam String title,
			@RequestParam String city,@RequestParam String state,@RequestParam String street,@RequestParam String zip_code,ModelMap model,
			HttpServletRequest  request,HttpServletResponse  response){
		
		System.out.println("here");
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory( "Assignment2_2756" );

		EntityManager entitymanager = emfactory.createEntityManager( );
		entitymanager.getTransaction( ).begin( );
		
		User user = entitymanager.find(User.class, uid);
		
		user.setFirstname(firstname);
		user.setLastname(lastname);
		user.setTitle(title);
		
		Address addr = new Address();
		addr.setCity(city);
		addr.setState(state);
		addr.setStreet(street);
		addr.setZip(zip_code);
		user.setAddress(addr);
		
		entitymanager.persist(user );
		entitymanager.getTransaction( ).commit( );

		entitymanager.close( );
		emfactory.close( );
		
		
		
		
		String redirect = "http://localhost:8080/user/"+uid;
		try{
			response.sendRedirect(redirect);
			
		}catch(Exception e){
			
		}
		
//		ModelAndView mv = new ModelAndView("addUser");
//		return mv;
	}


	



}
