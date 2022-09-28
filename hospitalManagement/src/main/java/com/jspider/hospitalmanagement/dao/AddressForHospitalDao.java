package com.jspider.hospitalmanagement.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.jspider.hospitalmanagement.dto.AddressForHospital;
import com.jspider.hospitalmanagement.dto.Hospital;

public class AddressForHospitalDao {
	public static EntityManager getEntityManager() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("dev");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		return entityManager;
	}

	public void saveAddressForHospital(int hospitalId, AddressForHospital address) {
		EntityManager entityManager = getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		HospitalDao dao = new HospitalDao();
		Hospital hospital = dao.getHospitalById(hospitalId);
		address.setHospital(hospital);
		if (hospital != null) {
			entityTransaction.begin();
			entityManager.persist(address);
			entityTransaction.commit();
		} else {
			System.out.println("please create the hospital");
		}
	}
}
