package com.jspider.hospitalmanagement.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.jspider.hospitalmanagement.dto.AddressForBranch;
import com.jspider.hospitalmanagement.dto.AddressForHospital;
import com.jspider.hospitalmanagement.dto.Branch;
import com.jspider.hospitalmanagement.dto.Hospital;

public class AddressForBranchDao {
	public static EntityManager getEntityManager() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("dev");
		return entityManagerFactory.createEntityManager();
	}

	public void saveAddressForBranch(int branchId, AddressForBranch address) {
		EntityManager entityManager = getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		BranchDao dao = new BranchDao();
		Branch branch = dao.getBranchByid(branchId);
		address.setBranch(branch);
		branch.setAddress(address);
		if (branch != null) {
			entityTransaction.begin();
			entityManager.persist(address);
			entityTransaction.commit();
		} else {
			System.out.println("please create the branch");
		}
	}
}
