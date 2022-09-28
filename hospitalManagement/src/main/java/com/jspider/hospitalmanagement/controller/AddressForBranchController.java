package com.jspider.hospitalmanagement.controller;

import com.jspider.hospitalmanagement.dao.AddressForBranchDao;
import com.jspider.hospitalmanagement.dao.AddressForHospitalDao;
import com.jspider.hospitalmanagement.dto.AddressForBranch;

public class AddressForBranchController {
	public static void main(String[] args) {
		AddressForBranchDao dao = new AddressForBranchDao();
		AddressForBranch address = new AddressForBranch();
		address.setStreet("Marathalli");
		address.setPincode(560031);
		address.setLandMark("Jspider building");
		dao.saveAddressForBranch(1, address);
	}
}
