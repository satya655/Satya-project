package com.jspider.hospitalmanagement.controller;

import java.util.Scanner;

import com.jspider.hospitalmanagement.dao.AddressForHospitalDao;
import com.jspider.hospitalmanagement.dao.HospitalDao;
import com.jspider.hospitalmanagement.dto.AddressForHospital;
import com.jspider.hospitalmanagement.dto.Hospital;

public class AddressForHospitalController {
	public static void main(String[] args) {
		AddressForHospitalDao addressDao = new AddressForHospitalDao();
		AddressForHospital address = new AddressForHospital();
		address.setStreet("btm");
		address.setLandMark("N R Tower");
		address.setPincode(560068);
		addressDao.saveAddressForHospital(1, address);
	}
}
