/**
 * 
 */
package edu.sjsu.cmpe275.lab2.dao;

import java.util.List;

import edu.sjsu.cmpe275.lab2.entity.PhoneEntity;

/**
 * @author SkandaBhargav
 *
 */
public interface PhoneDao {
	List<PhoneEntity> findAll();

}
