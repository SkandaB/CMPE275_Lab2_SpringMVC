/**
 * 
 */
package edu.sjsu.cmpe275.lab2.service;

import java.util.List;

import edu.sjsu.cmpe275.lab2.entity.PhoneEntity;

/**
 * @author SkandaBhargav
 *
 */
public interface PhoneService {

	/**
	 * @param number
	 * @param description
	 * @param city
	 * @param state
	 * @param street
	 * @param zip_code
	 * @return
	 */
	PhoneEntity createUser(String number, String description, String city, String state, String street,
			String zip_code);

	/**
	 * @param id
	 * @return
	 */
	PhoneEntity findById(int id);

	/**
	 * @param id
	 * @return
	 */
	public boolean deleteById(int id);

	/**
	 * @param id
	 * @param number
	 * @param description
	 * @param city
	 * @param state
	 * @param street
	 * @param zip_code
	 * @return
	 */
	PhoneEntity updatePhone(Integer id, String number, String description, String city, String state, String street,
			String zip_code);
	
}
