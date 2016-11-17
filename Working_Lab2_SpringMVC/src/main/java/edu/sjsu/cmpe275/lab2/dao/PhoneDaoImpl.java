/**
 * 
 */
package edu.sjsu.cmpe275.lab2.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
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
	@PersistenceContext(type=PersistenceContextType.EXTENDED)
	private EntityManager em;

	/* (non-Javadoc)
	 * @see edu.sjsu.cmpe275.lab2.dao.PhoneDao#findAll()
	 */
	@Override
	public List<PhoneEntity> findAll() {
		TypedQuery<PhoneEntity> query = em.createQuery("SELECT p FROM PhoneEntity p",PhoneEntity.class);
		List<PhoneEntity> results = query.getResultList();
		return results;
	}

	/* (non-Javadoc)
	 * @see edu.sjsu.cmpe275.lab2.dao.PhoneDao#findById(java.lang.Integer)
	 */
	@Override
	public PhoneEntity findById(Integer id) {
		// TODO Auto-generated method stub
		PhoneEntity pEntity = em.find(PhoneEntity.class, id);
		System.out.println("************************* Details of the retrieved phone = "+pEntity.toString());
		return pEntity;
	}
}
