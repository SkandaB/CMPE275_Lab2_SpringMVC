/**
 * 
 */
package stash.edu.sjsu.cmpe275.lab2.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import edu.sjsu.cmpe275.lab2.entity.PhoneEntity;
import edu.sjsu.cmpe275.lab2.entity.UserEntity;

/**
 * @author SkandaBhargav
 *
 */
@Repository
@Transactional
public class OfficeUserDaoImpl implements OfficeUserDao {

	@PersistenceContext
	private EntityManager manager;

	/* (non-Javadoc)
	 * @see stash.edu.sjsu.cmpe275.lab2.dao.OfficeUserDao#getAllUsers()
	 */
	public List<UserEntity> getAllUsers() {
		List<UserEntity> users = manager.createQuery("Select a from UserEntity a", UserEntity.class).getResultList();
		return users;
	}

	/* (non-Javadoc)
	 * @see stash.edu.sjsu.cmpe275.lab2.dao.OfficeUserDao#getAllPhones()
	 */
	@Override
	public List<PhoneEntity> getAllPhones() {
		List<PhoneEntity> phones = manager.createQuery("Select a from PhoneEntity a", PhoneEntity.class).getResultList();
		return phones;
	}

	/* (non-Javadoc)
	 * @see stash.edu.sjsu.cmpe275.lab2.dao.OfficeUserDao#addUser(edu.sjsu.cmpe275.lab2.entity.UserEntity)
	 */
	@Override
	public void addUser(UserEntity user) {
		manager.persist(user);
	}

}
