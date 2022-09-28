package com.jspider.hospitalmanagement.controller;

import com.jspider.hospitalmanagement.dao.EncounterDao;
import com.jspider.hospitalmanagement.dto.Encounter;

public class EncounterController {
	public static void main(String[] args) {
		EncounterDao dao = new EncounterDao();
		Encounter encounter = new Encounter();
		encounter.setName("Shambu Patil");
		encounter.setCause("fever");
		encounter.setEmail("shambu@gmail.com");
		encounter.setPhoNo(1234567890l);
		dao.saveEncounterByBranchId(1, encounter);
	}
}
