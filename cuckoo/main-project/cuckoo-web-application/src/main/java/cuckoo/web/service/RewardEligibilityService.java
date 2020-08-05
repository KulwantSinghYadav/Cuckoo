package cuckoo.web.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cuckoo.dao.impl.api.RewardEligibilityDao;
import com.model.core.model.api.RewardBalance;
import com.model.core.model.api.RewardEligibility;

/*
 * This class used for serve the request to the reward eligibility controller. 
 */

@Service("rewardEligibilityService")
public class RewardEligibilityService {

	@Autowired
	RewardEligibilityDao rewardEligibilityDao;
	
	@Transactional
	public List<RewardEligibility> getAllCitiRewardEligibility() {
		return rewardEligibilityDao.findAll();
	}

	@Transactional
	public RewardEligibility getRewardEligibility(Integer id) {
		return rewardEligibilityDao.findById(id);
	}

	@Transactional
	public void addRewardEligibility(RewardEligibility rewardEligibility) {
		rewardEligibilityDao.persist(rewardEligibility);
	}

	@Transactional
	public void deleteRewardEligibility(int id) {
		rewardEligibilityDao.remove(getRewardEligibility(id));
	}

	@Transactional
	public void updateCitiRewardEligibility(RewardEligibility rewardEligibility) {
		rewardEligibilityDao.merge(rewardEligibility);
	}
}
