package cuckoo.web.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cuckoo.config.api.utills.RewardLinkageUtills;
import com.cuckoo.dao.impl.api.RewardLinkageDao;
import com.model.core.constant.ApplicationConstant;
import com.model.core.model.api.RewardLinkage;

import io.city.core.api.client.reward.linkage.CallCitiRewardLinkage;

/*
 * This class used for serve the request to the reward linkage controller. 
 */

@Service("rewardLinkageService")
public class RewardLinkageService {

	@Autowired
	RewardLinkageDao rewardLinkageDao;

	CallCitiRewardLinkage callCitiRewardLinkage = new CallCitiRewardLinkage();

	@Transactional
	public List<RewardLinkage> getAllCitiRewardLinkage() {
		return rewardLinkageDao.findAll();
	}

	@Transactional
	public RewardLinkage getRewardLinkage(Integer id) {
		return rewardLinkageDao.findById(id);
	}

	@Transactional
	public void addRewardLinkage(RewardLinkage rewardLinkage) {
		rewardLinkageDao.persist(rewardLinkage);
	}

	@Transactional
	public void deleteRewardLinkage(int id) {
		rewardLinkageDao.remove(getRewardLinkage(id));
	}

	@Transactional
	public void updateRewardLinkage(RewardLinkage rewardLinkage) {
		rewardLinkageDao.merge(rewardLinkage);
	}
	
	@Transactional
	public void deleteRLByCCCN(String cloakedCreditCardNumbers) {
		rewardLinkageDao.deleteRLByCCCN(cloakedCreditCardNumbers);
	}

	public String getRewardLinkage(String cloakedCreditCardNumbers) {
		return rewardLinkageDao.getRewardLinkage(cloakedCreditCardNumbers);
	}

	public List<String> createRewardLinkageCode(String apiProduct, String endpoint, String accessToken, String contentType,
			String countryCode, String businessCode, String acceptLanguage, String accept,
			String cloakedCreditCardNumbers, String merchantCode, String rewardProgram, String billingZipCode)
			throws IOException {

		List<String> rewardLinkMainResponse = new ArrayList<String>();
		List<String> response = new ArrayList<String>();
		String getRewardLinkCode = "";

		deleteRLByCCCN(cloakedCreditCardNumbers);
		RewardLinkage rewardLinkageRequest = RewardLinkageUtills.setRewardLinkageRequest(cloakedCreditCardNumbers,
				merchantCode, rewardProgram, billingZipCode, ApplicationConstant.Pending, ApplicationConstant.City);

		addRewardLinkage(rewardLinkageRequest);

		String rewardLinkResponse = callCitiRewardLinkage.callCityRewardLinkage(apiProduct, endpoint, accessToken,
				contentType, countryCode, businessCode, acceptLanguage, accept, cloakedCreditCardNumbers, merchantCode,
				rewardProgram, billingZipCode);

		rewardLinkMainResponse = RewardLinkageUtills.getRewardLinkCode(rewardLinkResponse);

		if (rewardLinkMainResponse.size() > 0) {

			String status = "";
			if (rewardLinkMainResponse.get(0).equalsIgnoreCase("errors")) {
				status = ApplicationConstant.Error;
				response.add(rewardLinkMainResponse.get(0));
				response.add(rewardLinkMainResponse.get(1));

				RewardLinkage rewardLinkage = getRewardLinkage(rewardLinkageRequest.getTransId());
				RewardLinkage rewardLinkageResponse = RewardLinkageUtills.setRewardLinkageResponse(rewardLinkage,
						status, getRewardLinkCode);
				updateRewardLinkage(rewardLinkageResponse);

				return response;
			} else {
				status = ApplicationConstant.Completed;

				response.add(rewardLinkMainResponse.get(0));
				RewardLinkage rewardLinkage = getRewardLinkage(rewardLinkageRequest.getTransId());
				RewardLinkage rewardLinkageResponse = RewardLinkageUtills.setRewardLinkageResponse(rewardLinkage,
						status, rewardLinkMainResponse.get(0));
				
				updateRewardLinkage(rewardLinkageResponse);
			}
		}

		return response;

	}

}
