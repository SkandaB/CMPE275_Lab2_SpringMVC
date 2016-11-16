/**
 * 
 */
package edu.sjsu.cmpe275.lab2.service;

import java.util.List;

import edu.sjsu.cmpe275.lab2.entity.*;

/**
 * @author SkandaBhargav
 *
 */
public interface UserSerivce {
	public List<UserEntity> getAllUsers();
	public void AddUser(UserEntity user);
}
