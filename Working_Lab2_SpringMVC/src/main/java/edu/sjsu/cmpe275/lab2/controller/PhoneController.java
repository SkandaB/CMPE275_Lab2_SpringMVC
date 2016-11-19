package edu.sjsu.cmpe275.lab2.Controller;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import edu.sjsu.cmpe275.lab2.Entity.Address;
import edu.sjsu.cmpe275.lab2.Entity.Phone;
import edu.sjsu.cmpe275.lab2.Entity.User;

@Controller
public class PhoneController {
	//@Autowired private PhoneService phoneService;
	@RequestMapping(value="/phone", method = RequestMethod.GET)
	public ModelAndView showUserCreationForm(){
		
		ModelAndView modelAndView = new ModelAndView("addPhone");
		return modelAndView;
	}
	
	@RequestMapping(value="/phone", method = RequestMethod.POST)
	public void phoneCreating(@RequestParam String number,@RequestParam String description,
			@RequestParam String city,@RequestParam String state,@RequestParam String street,@RequestParam String zip_code,ModelMap model,
			HttpServletRequest  request,HttpServletResponse  response){
		
		
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory( "Assignment2_2756" );

		EntityManager entitymanager = emfactory.createEntityManager( );
		entitymanager.getTransaction( ).begin( );


		Phone phone = new Phone();
		phone.setNumber(number);
		phone.setDescription(description);
		
		Address addr = new Address();
		addr.setCity(city);
		addr.setState(state);
		addr.setStreet(street);
		addr.setZip(zip_code);
		phone.setAddress(addr);
		entitymanager.persist(phone );
		entitymanager.getTransaction( ).commit( );

		entitymanager.close( );
		emfactory.close( );
		
		long pid = phone.getId();
		
		
		String redirect = "http://localhost:8080/phone/"+pid;
		try{
			response.sendRedirect(redirect);
			
		}catch(Exception e){
			
		}
		

	}
	
	@RequestMapping(value="/phone/{pid}", method = RequestMethod.GET)
	public ModelAndView afterPhoneCreationForm(@PathVariable long pid){
		
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory( "Assignment2_2756" );

		EntityManager entitymanager = emfactory.createEntityManager( );
		entitymanager.getTransaction( ).begin( );
		
		Phone phone = entitymanager.find(Phone.class,pid);
		
		List<User> users = (List<User>) entitymanager.createQuery("select u from User u",User.class).getResultList();
		//phone.setUsers(users);
		
		entitymanager.getTransaction( ).commit( );
		
		ModelAndView mv = new ModelAndView("phoneInfo");
		mv.addObject("phone", phone);
		mv.addObject("users",users);
		
		return mv;
	}
	
	@RequestMapping(value="/phone/{pid}",method = RequestMethod.POST)
	public void updateUser(@PathVariable long pid,@RequestParam String number,@RequestParam String description,
			@RequestParam String city,@RequestParam String state,@RequestParam String street,@RequestParam String zip_code,@RequestParam String uid,ModelMap model,
			HttpServletRequest  request,HttpServletResponse  response){

		
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory( "Assignment2_2756" );

		EntityManager entitymanager = emfactory.createEntityManager( );
		entitymanager.getTransaction( ).begin( );
		
		Phone phone = entitymanager.find(Phone.class, pid);
		
		phone.setNumber(number);
		phone.setDescription(description);

		
		Address addr = new Address();
		addr.setCity(city);
		addr.setState(state);
		addr.setStreet(street);
		addr.setZip(zip_code);
		phone.setAddress(addr);
		
		List<User> temp_users = new ArrayList<User>();
		temp_users.add(entitymanager.find(User.class, uid));
		System.out.println("here");
		System.out.println(temp_users);
		phone.getUsers().add(temp_users.get(0));
		//phone.setUsers(temp_users);
		
		temp_users.get(0).getPhones().add(phone);
		
		entitymanager.persist(temp_users.get(0));
		
	    entitymanager.persist(phone);
		/*entitymanager.merge(phone);
		entitymanager.flush();*/
		entitymanager.getTransaction( ).commit( );
		
		Phone temp = entitymanager.find(Phone.class, pid);
		System.out.println("user phones" + temp.getNumber() + " " + temp.getUsers());

		entitymanager.close( );
		emfactory.close( );
		
		
		
		
		String redirect = "http://localhost:8080/phone/"+pid;
		try{
			response.sendRedirect(redirect);
			
		}catch(Exception e){
			
		}
		
//		ModelAndView mv = new ModelAndView("addUser");
//		return mv;
	}
	
	@RequestMapping(value="/phone/{pid}", method = RequestMethod.DELETE)
	public ModelAndView deleteUser(@PathVariable long pid){
		
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory( "Assignment2_2756" );

		EntityManager entitymanager = emfactory.createEntityManager( );
		entitymanager.getTransaction( ).begin( );
		Phone phone = entitymanager.find(Phone.class, pid);
		
		if(phone.getUsers().isEmpty())
			entitymanager.remove(phone);
		
		else
			System.out.println("cannot delete since the phone is assigned to some users");
		entitymanager.getTransaction( ).commit( );

		ModelAndView mv = new ModelAndView("addPhone");
	
		
		return mv;
		

	}

}
