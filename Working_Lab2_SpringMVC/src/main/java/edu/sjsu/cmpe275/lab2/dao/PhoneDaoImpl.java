/**
 * 
 */
package edu.sjsu.cmpe275.lab2.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import org.springframework.transaction.annotation.Transactional;

import edu.sjsu.cmpe275.lab2.entity.PhoneEntity;

/**
 * @author SkandaBhargav
 *
 */
@Transactional
public class PhoneDaoImpl implements PhoneDao {

	/* (non-Javadoc)
	 * @see edu.sjsu.cmpe275.lab2.dao.PhoneDao#findAll()
	 */
	
@Override
	public List<PhoneEntity> findAll() {
	System.out.println("***********************!!!!!!! -------- Coming till before query launch!!!");

		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory( "Lab2_CMPE275" );

		EntityManager entitymanager = emfactory.createEntityManager( );
		 TypedQuery<PhoneEntity> query =
				 entitymanager.createQuery("SELECT p FROM PHONE_DETAILS p", PhoneEntity.class);
			  List<PhoneEntity> results = query.getResultList();
			  System.out.println(query);
			  System.out.println(results.iterator().next());
			  System.out.println("***********************!!!!!!! -------- Coming till here!!!");
		// TODO Auto-generated method stub
		return results;
	}

}
