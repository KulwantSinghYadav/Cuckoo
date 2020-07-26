package cuckoo.web.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cuckoo.dao.impl.api.RewardBalanceDao;
import com.model.core.model.api.RewardBalance;


/*
 * This class used for serve the request to the reward balance controller. 
 */

@Service("rewardBalanceService")
public class RewardBalanceService {

	@Autowired
	RewardBalanceDao rewardBalanceDao;
	
	@Transactional
	public List<RewardBalance> getAllCitiRewardBalance() {
		return rewardBalanceDao.findAll();
	}

	@Transactional
	public RewardBalance getCitiRewardBalance(int id) {
		return rewardBalanceDao.findById(id);
	}

	@Transactional
	public void addCitiRewardBalance(RewardBalance rewardBalance) {
		rewardBalanceDao.persist(rewardBalance);
	}

	@Transactional
	public void deleteCitiRewardBalance(int id) {
		rewardBalanceDao.remove(getCitiRewardBalance(id));
	}

}
