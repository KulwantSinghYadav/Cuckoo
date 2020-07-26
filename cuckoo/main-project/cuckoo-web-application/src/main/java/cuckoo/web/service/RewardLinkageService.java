package cuckoo.web.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cuckoo.dao.impl.api.RewardLinkageDao;
import com.model.core.model.api.RewardLinkage;

/*
 * This class used for serve the request to the reward linkage controller. 
 */

@Service("rewardLinkageService")
public class RewardLinkageService {

	@Autowired
	RewardLinkageDao RewardLinkageDao;
	
	@Transactional
	public List<RewardLinkage> getAllCitiRewardLinkage() {
		return RewardLinkageDao.findAll();
	}

	@Transactional
	public RewardLinkage getRewardLinkage(int id) {
		return RewardLinkageDao.findById(id);
	}

	@Transactional
	public void addRewardLinkage(RewardLinkage RewardLinkage) {
		RewardLinkageDao.persist(RewardLinkage);
	}

	@Transactional
	public void deleteRewardLinkage(int id) {
		RewardLinkageDao.remove(getRewardLinkage(id));
	}

}

