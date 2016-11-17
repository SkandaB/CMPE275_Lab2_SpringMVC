/**
 * 
 */
package edu.sjsu.cmpe275.lab2.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import edu.sjsu.cmpe275.lab2.entity.PhoneEntity;

/**
 * @author SkandaBhargav
 *
 */
@Repository
public class PhoneDaoImpl implements PhoneDao {
	@PersistenceContext
	private EntityManager em;

	/* (non-Javadoc)
	 * @see edu.sjsu.cmpe275.lab2.dao.PhoneDao#findAll()
	 */

	@Override
	public List<PhoneEntity> findAll() {
		System.out.println("***********************!!!!!!! -------- Coming till before query launch!!!");

		TypedQuery<PhoneEntity> query = em.createQuery("SELECT p FROM PhoneEntity p",PhoneEntity.class);
		List<PhoneEntity> results = query.getResultList();
		for (PhoneEntity c : results) {
			System.out.println("ID = "+ c.getId() +", Number = " + c.getNumber());
		}
		return results;

		/*EntityManagerFactory emfactory = Persistence.createEntityManagerFactory( "Lab2_CMPE275" );

	EntityManager entitymanager = emfactory.createEntityManager( );
	entitymanager.getTransaction().begin();
	TypedQuery<PhoneEntity> query = entitymanager.createQuery("SELECT p FROM PhoneEntity p",PhoneEntity.class);
	List<PhoneEntity> results = query.getResultList();
	for (PhoneEntity c : results) {
		System.out.println("ID = "+ c.getId() +"Number = " + c.getNumber());
	}
	entitymanager.close();
	return results;*/
	}

}

/*EntityManagerFactory emfactory = Persistence.createEntityManagerFactory( "Lab2_CMPE275" );

EntityManager entitymanager = emfactory.createEntityManager( );
entitymanager.getTransaction().begin();
TypedQuery<PhoneEntity> query = entitymanager.createQuery("SELECT p FROM PhoneEntity p",PhoneEntity.class);
List<PhoneEntity> results = query.getResultList();
for (PhoneEntity c : results) {
	System.out.println("ID = "+ c.getId() +"Number = " + c.getNumber());
}
entitymanager.close();
return results;
 */