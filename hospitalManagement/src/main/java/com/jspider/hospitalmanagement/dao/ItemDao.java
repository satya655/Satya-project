package com.jspider.hospitalmanagement.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.jspider.hospitalmanagement.dto.Items;
import com.jspider.hospitalmanagement.dto.MedOrder;

public class ItemDao {
	public static EntityManager getEntityManager() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("dev");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		return entityManager;
	}

	public void saveItemByMedOrderId(int medorderId, Items item) {
		EntityManager entityManager = getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		MedOrderDao dao = new MedOrderDao();
		MedOrder medOrder = dao.getMedOrderById(medorderId);

		List<MedOrder> medOrders = new ArrayList<MedOrder>();
		medOrders.add(medOrder);

		List<Items> items = new ArrayList<Items>();
		items.add(item);

		medOrder.setItems(items);
		item.setMedOrder(medOrders);

		if (medOrder != null) {
			entityTransaction.begin();
			entityManager.persist(item);
			entityTransaction.commit();
		} else {
			System.out.println("before creating items first create MedOrder");
		}
	}

	public Items getItemById(int itemId) {
		EntityManager entityManager = getEntityManager();
		return entityManager.find(Items.class, itemId);
	}

	public List<Items> getAlliteItems() {
		EntityManager entityManager = getEntityManager();
		Query query = entityManager.createQuery("SELECT I FROM Items I");
		List<Items> items = query.getResultList();
		return items;
	}
}
