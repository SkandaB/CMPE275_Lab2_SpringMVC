/**
 * 
 */
package edu.sjsu.cmpe275.lab2.service;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Service;

import edu.sjsu.cmpe275.lab2.dao.PhoneDao;
import edu.sjsu.cmpe275.lab2.entity.*;
/**
 * @author SkandaBhargav
 *
 */
@Service("PhoneService")
public class PhoneServiceImpl implements PhoneService {
private PhoneDao phoneDao; 
	
	/**
	 * @return
	 */
@Override
	public List<PhoneEntity> findAll() {
		// TODO Auto-generated method stub
	System.out.println("********************* Before call to DAO ************");
	
	EntityManagerFactory emfactory = Persistence.createEntityManagerFactory( "Lab2_CMPE275" );

	EntityManager entitymanager = emfactory.createEntityManager( );
	 TypedQuery<PhoneEntity> query =
			 entitymanager.createQuery("SELECT c FROM PHONE_DETAILS c",PhoneEntity.class);
		  List<PhoneEntity> results = query.getResultList();
		  for (PhoneEntity c : results) {
		      System.out.println(c.getNumber());
		  }
		  return results;
		//return phoneDao.findAll();

	}

}
