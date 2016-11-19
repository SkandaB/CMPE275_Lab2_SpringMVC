/**
 * 
 */
package edu.sjsu.cmpe275.lab2.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.TypedQuery;

import org.springframework.jdbc.core.metadata.GenericTableMetaDataProvider;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import edu.sjsu.cmpe275.lab2.entity.PhoneEntity;
import edu.sjsu.cmpe275.lab2.entity.UserEntity;

/**
 * @author SkandaBhargav
 *
 */
@Repository
public class PhoneDaoImpl implements PhoneDao {
	@PersistenceContext(type=PersistenceContextType.EXTENDED)
	private EntityManager em;

	/* (non-Javadoc)
	 * @see edu.sjsu.cmpe275.lab2.dao.PhoneDao#createPhone(edu.sjsu.cmpe275.lab2.entity.PhoneEntity)
	 */
	@Override
	public PhoneEntity createPhone(PhoneEntity phoneEntity) {
		em.persist(phoneEntity);
		return phoneEntity;
	}

	/* (non-Javadoc)
	 * @see edu.sjsu.cmpe275.lab2.dao.PhoneDao#findById(int)
	 */
	@Override
	public PhoneEntity findById(int id) {
		PhoneEntity pEntity = em.find(PhoneEntity.class, id);
		return pEntity;
	}

	/* (non-Javadoc)
	 * @see edu.sjsu.cmpe275.lab2.dao.PhoneDao#deleteById(int)
	 */
	@Override
	public Boolean deleteById(int id) {
		PhoneEntity phoneEntity = em.find(PhoneEntity.class, id);
		em.remove(phoneEntity);
		return true;
	}

	/* (non-Javadoc)
	 * @see edu.sjsu.cmpe275.lab2.dao.PhoneDao#updatePhone(java.lang.Integer, edu.sjsu.cmpe275.lab2.entity.PhoneEntity)
	 */
	@Override
	public PhoneEntity updatePhone(Integer id, PhoneEntity phoneEntity) {
		PhoneEntity pEntity = em.find(PhoneEntity.class,id);
		
		pEntity.setNumber(phoneEntity.getNumber());
		pEntity.setDescription(phoneEntity.getDescription());
		pEntity.setAddress(phoneEntity.getAddress());
		
		em.persist(pEntity);
		return pEntity;
	}
}
