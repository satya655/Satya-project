package com.jspider.hospitalmanagement.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.jspider.hospitalmanagement.dto.Encounter;
import com.jspider.hospitalmanagement.dto.MedOrder;

public class MedOrderDao {
	public static EntityManager getEntityManager() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("dev");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		return entityManager;
	}

	public void saveMedOrderByEncounterId(int encounterId, MedOrder medOrder) {
		EntityManager entityManager = getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		EncounterDao dao = new EncounterDao();
		Encounter encounter = dao.getEncounterById(encounterId);
		List<MedOrder> medOrders = new ArrayList<MedOrder>();
		medOrders.add(medOrder);

		encounter.setMedOrder(medOrders);
		medOrder.setEncounter(encounter);

		if (encounter != null) {
			entityTransaction.begin();
			entityManager.persist(medOrder);
			entityTransaction.commit();
		} else {
			System.out.println("before createing medOrder first create encounter");
		}
	}

	public MedOrder getMedOrderById(int medOrderId) {
		EntityManager entityManager = getEntityManager();
		return entityManager.find(MedOrder.class, medOrderId);
	}

	public List<MedOrder> getAllTheMidOrders() {
		EntityManager entityManager = getEntityManager();
		Query query = entityManager.createQuery("SELECT M FROM MedOrder M");
		List<MedOrder> medOrders = query.getResultList();
		return medOrders;
	}
}
