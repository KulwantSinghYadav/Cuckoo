package com.cuckoo.dao.impl.api;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.cuckoo.dao.generic.DaoImpl;
import com.model.core.model.api.RewardLinkage;

@Repository
@Component("rewardLinkageDao")
public class RewardLinkageDaoImpl extends DaoImpl<Integer, RewardLinkage> implements RewardLinkageDao {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public String getRewardLinkage(String cccn) {

		RewardLinkage rewardLinkageCode = new RewardLinkage();
		try {
			String hqlQuery = "from RewardLinkage rl where rl.cloakedCreditCardNumber = :cccn";
			rewardLinkageCode = (RewardLinkage) entityManager.createQuery(hqlQuery)
					.setParameter("cccn", cccn).setMaxResults(1).getSingleResult();
			entityManager.close();
		} catch (Exception e) {
			System.out.println("Error occurred during fetching RewardLinkage record" + e);
		}
		
		return rewardLinkageCode.getRewardLinkCode();
	}

	@Override
	public void deleteRLByCCCN(String cccn) {
		try {
			String hqlQuery = "delete from RewardLinkage rl where rl.cloakedCreditCardNumber = :cccn";
			entityManager.createQuery(hqlQuery).setParameter("cccn", cccn).executeUpdate();
			entityManager.close();
		} catch (Exception e) {
			System.out.println("Error occurred during deleting RewardLinkage record" + e);
		}
	}

}
