package cuckoo.web.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cuckoo.dao.impl.api.RewardEnablementDao;
import com.model.core.model.api.RewardEnablement;

/*
 * This class used for serve the request to the reward enablement controller. 
 */

@Service("rewardEnablementService")
public class RewardEnablementService {

	@Autowired
	RewardEnablementDao rewardEnablementDao;
	
	@Transactional
	public List<RewardEnablement> getAllCitiRewardEnablement() {
		return rewardEnablementDao.findAll();
	}

	@Transactional
	public RewardEnablement getRewardEnablement(int id) {
		return rewardEnablementDao.findById(id);
	}

	@Transactional
	public void addRewardEnablement(RewardEnablement rewardEnablement) {
		rewardEnablementDao.persist(rewardEnablement);
	}

	@Transactional
	public void deleteRewardEnablement(int id) {
		rewardEnablementDao.remove(getRewardEnablement(id));
	}

	@Transactional
	public void updateRewardEnablement(RewardEnablement rewardEnablement) {
		rewardEnablementDao.merge(rewardEnablement);
	}
}
