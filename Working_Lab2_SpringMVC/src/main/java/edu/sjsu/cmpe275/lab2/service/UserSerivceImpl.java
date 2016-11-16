package edu.sjsu.cmpe275.lab2.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import edu.sjsu.cmpe275.lab2.entity.AddressEntity;
import edu.sjsu.cmpe275.lab2.entity.PhoneEntity;
import edu.sjsu.cmpe275.lab2.entity.UserEntity;

@Service
public class UserSerivceImpl implements UserSerivce {
	
	//@RequestMapping(value = "/user")
	public String userCreation() {
	EntityManagerFactory emfactory = Persistence.createEntityManagerFactory( "Lab2_CMPE275" );

		EntityManager entitymanager = emfactory.createEntityManager( );
		entitymanager.getTransaction( ).begin( );


		UserEntity user = new UserEntity();
		PhoneEntity phone=new PhoneEntity();
		AddressEntity address=new AddressEntity();
		AddressEntity phoneAddress=new AddressEntity();
		
		
		phone.setNumber("9876543210");
		phoneAddress.setCity("San Jose");
		phoneAddress.setStreet("3rd St");
		phoneAddress.setZip("95112");
		phoneAddress.setState("CA");
		phone.setAddress(phoneAddress);
		
		
		address.setCity("San Mateo");
		address.setStreet("Richard");
		address.setZip("95323");
		address.setState("CA");
		user.setAddress(address);

		user.setFirstname("Skanda");
		user.setLastname("Bhargav");
		user.setTitle("Software Engineer");
		user.setAddress(address);
		user.getPhone().add(phone);
		
		entitymanager.persist(user);
		entitymanager.getTransaction( ).commit( );

		entitymanager.close( );
		emfactory.close( );
		System.out.println("hkkjr");
		ModelAndView modelandview = new ModelAndView("home");

		return "welcome";
	}

	/* (non-Javadoc)
	 * @see edu.sjsu.cmpe275.lab2.service.UserSerivce#getAllUsers()
	 */
	@Override
	public List<UserEntity> getAllUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see edu.sjsu.cmpe275.lab2.service.UserSerivce#AddUser(edu.sjsu.cmpe275.lab2.entity.UserEntity)
	 */
	@Override
	public void AddUser(UserEntity user) {
		// TODO Auto-generated method stub
		
	}

}
 