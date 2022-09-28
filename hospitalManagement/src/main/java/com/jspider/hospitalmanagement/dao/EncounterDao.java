package com.jspider.hospitalmanagement.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.jspider.hospitalmanagement.dto.Branch;
import com.jspider.hospitalmanagement.dto.Encounter;

public class EncounterDao {
	public static EntityManager getEntityManager() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("dev");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		return entityManager;
	}

	public void saveEncounterByBranchId(int branchid, Encounter encounter) {
		EntityManager entityManager = getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		Branch branch = entityManager.find(Branch.class, branchid);
		List<Encounter> encounters = new ArrayList<Encounter>();
		encounters.add(encounter);

		branch.setEncounter(encounters);
		encounter.setBranch(branch);

		if (encounter != null) {
			entityTransaction.begin();
			entityManager.persist(encounter);
			entityTransaction.commit();
		} else {
			System.out.println("before adding encounter first create the branch");
		}
	}

	public Encounter getEncounterById(int encounterid) {
		EntityManager entityManager = getEntityManager();
		return entityManager.find(Encounter.class, encounterid);
	}
}
