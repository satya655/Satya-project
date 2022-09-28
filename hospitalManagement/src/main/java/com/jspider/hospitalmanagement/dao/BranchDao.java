package com.jspider.hospitalmanagement.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.jspider.hospitalmanagement.dto.Branch;
import com.jspider.hospitalmanagement.dto.Hospital;

public class BranchDao {
	public static EntityManager getEntityManager() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("dev");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		return entityManager;
	}

	public void saveBranchByHospital(int hospitalId, Branch branch) {
		EntityManager entityManager = getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		HospitalDao dao = new HospitalDao();
		Hospital hospital = dao.getHospitalById(hospitalId);

		List<Branch> branchs = new ArrayList<Branch>();
		branchs.add(branch);

		hospital.setBranch(branchs);
		branch.setHospital(hospital);

		if (hospital != null) {
			entityTransaction.begin();
			entityManager.persist(branch);
			entityTransaction.commit();
		} else {
			System.out.println("plese crreate the hopital first");
		}
	}

	public Branch getBranchByid(int branchId) {
		EntityManager entityManager = getEntityManager();
		Branch branch = entityManager.find(Branch.class, branchId);
		return branch;
	}
}
