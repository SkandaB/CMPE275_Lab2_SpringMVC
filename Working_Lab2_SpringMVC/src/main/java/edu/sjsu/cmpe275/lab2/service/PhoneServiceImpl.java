/**
 * 
 */
package edu.sjsu.cmpe275.lab2.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.sjsu.cmpe275.lab2.dao.PhoneDao;
import edu.sjsu.cmpe275.lab2.entity.PhoneEntity;
/**
 * @author SkandaBhargav
 *
 */
@Service()
public class PhoneServiceImpl implements PhoneService {
	@Autowired
	PhoneDao phoneDao; 

	/**
	 * @return
	 */
	@Override
	@Transactional
	public List<PhoneEntity> findAll() {
		return phoneDao.findAll();
	}

	/* (non-Javadoc)
	 * @see edu.sjsu.cmpe275.lab2.service.PhoneService#findById(int)
	 */
	@Override
	@Transactional
	public PhoneEntity findById(Integer id) {
		// TODO Auto-generated method stub
		return phoneDao.findById(id);
		
	}
}