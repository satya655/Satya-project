package com.jspider.hospitalmanagement.controller;

import com.jspider.hospitalmanagement.dao.HospitalDao;
import com.jspider.hospitalmanagement.dto.Hospital;

public class HospitalController {
	public static void main(String[] args) {
		HospitalDao dao = new HospitalDao();
		Hospital hospital = new Hospital();
		hospital.setName("Apollo");
		hospital.setEmail("Apollo@gmail.com");
		hospital.setGst("GST:APOLLO:12345:9006");
		hospital.setPhoneNumber(1234567890l);
		hospital.setWebsite("www.apollohospital.com");
		dao.saveHospital(hospital);
	}
}
