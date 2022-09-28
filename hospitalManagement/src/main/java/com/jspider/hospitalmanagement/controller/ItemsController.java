package com.jspider.hospitalmanagement.controller;

import com.jspider.hospitalmanagement.dao.ItemDao;
import com.jspider.hospitalmanagement.dto.Items;

public class ItemsController {
	public static void main(String[] args) {
		ItemDao dao = new ItemDao();
		Items items = new Items();
		items.setName("Dolol650");
		items.setCost(50);
		dao.saveItemByMedOrderId(1, items);
	}
}
