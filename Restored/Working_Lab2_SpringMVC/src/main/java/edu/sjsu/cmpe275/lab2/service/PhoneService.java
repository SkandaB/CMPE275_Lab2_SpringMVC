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
	 * @return
	 */
	List<PhoneEntity> findAll();

	/**
	 * @param id
	 */
	PhoneEntity findById(Integer id);

}
