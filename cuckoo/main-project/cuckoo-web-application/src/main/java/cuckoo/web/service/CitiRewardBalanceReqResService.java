package cuckoo.web.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cuckoo.dao.impl.city.CitiRewardBalanceReqResDao;
import com.model.core.model.city.CitiRewardBalanceRequestResponse;

@Service("citiRewardBalanceReqResService")
public class CitiRewardBalanceReqResService {

	@Autowired
	CitiRewardBalanceReqResDao citiRewardBalanceReqResDao;
	
	@Transactional
	public List<CitiRewardBalanceRequestResponse> getAllCitiRBReqRes() {
		return citiRewardBalanceReqResDao.findAll();
	}

	@Transactional
	public CitiRewardBalanceRequestResponse getCitiRBReqRes(int id) {
		return citiRewardBalanceReqResDao.findById(id);
	}

	@Transactional
	public void addCitiRBReqRes(CitiRewardBalanceRequestResponse cityData) {
		citiRewardBalanceReqResDao.persist(cityData);
	}

	@Transactional
	public void deleteCitiRBReqRes(int id) {
		citiRewardBalanceReqResDao.remove(getCitiRBReqRes(id));
	}

}
