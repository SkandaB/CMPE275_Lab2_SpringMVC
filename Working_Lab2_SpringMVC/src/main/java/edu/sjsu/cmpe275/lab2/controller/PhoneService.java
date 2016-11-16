/**
 * 
 */
package edu.sjsu.cmpe275.lab2.controller;

import org.springframework.stereotype.Service;

import edu.sjsu.cmpe275.lab2.entity.AddressEntity;
import edu.sjsu.cmpe275.lab2.entity.PhoneEntity;

/**
 * @author SkandaBhargav
 *
 */

@Service
public class PhoneService {
	public String PhoneCreation() {
		
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
		
		
		return "welcome";
	}

}
