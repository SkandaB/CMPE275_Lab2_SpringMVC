/**
 * 
 */
package edu.sjsu.cmpe275.lab2.dao;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import edu.sjsu.cmpe275.lab2.entity.PhoneEntity;

/**
 * @author SkandaBhargav
 *
 */

@Transactional
public interface PhoneDao {
	List<PhoneEntity> findAll();

	/**
	 * @param id
	 * @return
	 */
	PhoneEntity findById(Integer id);

}
