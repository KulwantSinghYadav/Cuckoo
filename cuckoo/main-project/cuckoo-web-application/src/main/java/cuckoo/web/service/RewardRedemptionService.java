package cuckoo.web.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cuckoo.dao.impl.api.RewardRedemptionDao;
import com.model.core.model.api.RewardRedemption;

/*
 * This class used for serve the request to the reward redemption controller. 
 */

@Service("rewardRedemptionService")
public class RewardRedemptionService {
	
	@Autowired
	RewardRedemptionDao rewardRedemptionDao;
	
	@Transactional
	public List<RewardRedemption> getAllCitiRewardRedemption() {
		return rewardRedemptionDao.findAll();
	}

	@Transactional
	public RewardRedemption getRewardRedemption(int id) {
		return rewardRedemptionDao.findById(id);
	}

	@Transactional
	public void addRewardRedemption(RewardRedemption rewardRedemption) {
		rewardRedemptionDao.persist(rewardRedemption);
	}

	@Transactional
	public void deleteRewardRedemption(int id) {
		rewardRedemptionDao.remove(getRewardRedemption(id));
	}

}
