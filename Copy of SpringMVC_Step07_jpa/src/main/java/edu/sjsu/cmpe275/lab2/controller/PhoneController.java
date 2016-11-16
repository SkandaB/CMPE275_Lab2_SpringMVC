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


@Controller
//@RequestMapping("/user")
public class PhoneController {
	//@Autowired private UserService userService;

	/*@RequestMapping(method = RequestMethod.GET)
	public String listAll(Model model) {
		model.addAttribute("users", userService.getAll());
		return "users";
	}

	@RequestMapping(value = "/addUser", method = RequestMethod.POST)
	public String addPerson(@ModelAttribute UserEntity user) {
		userService.add(user);
		return "redirect:/";
	}*/

	/**
	 * 
	 */
	
	/*@RequestMapping(value="/addUser", method = RequestMethod.POST)
	public String userCreating(@RequestParam String first_name,@RequestParam String last_name,@RequestParam String title, ModelMap model){
		
		model.put("first_name", first_name);
		model.put("last_name", last_name);
		model.put("title", title);
		return "welcome";
	}*/


	@RequestMapping("/phone")
	public String userCreation(){
		
/*		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory( "Assignment2_2756" );

		EntityManager entitymanager = emfactory.createEntityManager( );
		entitymanager.getTransaction( ).begin( );


		PhoneEntity phone=new PhoneEntity();
		phone.setNumber("12345689");
		AddressEntity phoneAddress=new AddressEntity();
		phoneAddress.setCity("Latur");
		phoneAddress.setStreet("mg nagar");
		phoneAddress.setZip("40068");
		phone.setAddress(phoneAddress);



		PhoneEntity phone1=new PhoneEntity();
		phone1.setNumber("0000000000");
		AddressEntity phoneAddress1=new AddressEntity();
		phoneAddress1.setCity("YYYY");
		phoneAddress1.setStreet("XXXX");
		phoneAddress1.setZip("9999");
		phone1.setAddress(phoneAddress1);


		//course.setFee(100);
		//course.setTitle("Ajeet");
		//
		user.setFirstname("Ajeet");
		user.setLastname("Sahu");
		user.setTitle("Principla software Engineer");


		user1.setFirstname("Ruchit");
		user1.setLastname("tom");
		user1.setTitle("ekwjrthgou software Engineer");
		AddressEntity a2=new AddressEntity();
		a2.setCity("Dadar");
		a2.setStreet("West street");
		a2.setZip("348912");
		user1.setAddress(a2);

		user2.setFirstname("Dheerakj");
		user2.setLastname("jhdfs");
		user2.setTitle("ekwjrthgou software Engineer");


		AddressEntity a3=new AddressEntity();
		a3.setCity("Wadala");
		a3.setStreet("West street");
		a3.setZip("348912");
		user2.setAddress(a3);






		AddressEntity a1=new AddressEntity();
		a1.setCity("Lucknow");
		a1.setStreet("Wasseypur street");
		a1.setZip("95510");
		user.setAddress(a1);


		user.getPhone().add(phone1);
		user.getPhone().add(phone);

		user1.getPhone().add(phone1);

		phone1.getUsers().add(user2);
		phone.getUsers().add(user1);


		entitymanager.persist(user );
		entitymanager.persist(user1 );
		entitymanager.persist(user2);



		entitymanager.getTransaction( ).commit( );

		entitymanager.close( );
		emfactory.close( );
		System.out.println("hkkjr");
		ModelAndView modelandview = new ModelAndView("home");

*/		
		return "welcome";
	}



}
