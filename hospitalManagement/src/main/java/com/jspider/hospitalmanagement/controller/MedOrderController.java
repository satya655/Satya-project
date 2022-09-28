package com.jspider.hospitalmanagement.controller;

import com.jspider.hospitalmanagement.dao.MedOrderDao;
import com.jspider.hospitalmanagement.dto.MedOrder;

public class MedOrderController {
	public static void main(String[] args) {
		MedOrderDao dao = new MedOrderDao();
		MedOrder medOrder = new MedOrder();
		medOrder.setName("xyz");
		medOrder.setPrice(566.25);
		medOrder.setListOfItems("Dolo650 and Cipla");
		dao.saveMedOrderByEncounterId(1, medOrder);
	}
}
