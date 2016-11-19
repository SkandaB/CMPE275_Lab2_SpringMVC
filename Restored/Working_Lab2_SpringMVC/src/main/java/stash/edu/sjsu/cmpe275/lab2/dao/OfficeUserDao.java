/**
 * 
 */
package stash.edu.sjsu.cmpe275.lab2.dao;
import java.util.List;

import edu.sjsu.cmpe275.lab2.entity.*;

/**
 * @author SkandaBhargav
 *
 */
public interface OfficeUserDao {
	public List<UserEntity> getAllUsers();
	public List<PhoneEntity> getAllPhones();
	public void addUser(UserEntity user);
}
