package com.jspider.hospitalmanagement.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.jspider.hospitalmanagement.dto.Hospital;

public class HospitalDao {
	public static EntityManager getEntityManager() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("dev");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		return entityManager;
	}

	public void saveHospital(Hospital hospital) {
		EntityManager entityManager = getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		entityTransaction.begin();
		entityManager.persist(hospital);
		entityTransaction.commit();
	}

	public Hospital getHospitalById(int hospitalid) {
		EntityManager entityManager = getEntityManager();
		Hospital hospital = entityManager.find(Hospital.class, hospitalid);
		return hospital;
	}
}
