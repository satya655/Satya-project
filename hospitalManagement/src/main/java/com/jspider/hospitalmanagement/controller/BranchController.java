package com.jspider.hospitalmanagement.controller;

import com.jspider.hospitalmanagement.dao.BranchDao;
import com.jspider.hospitalmanagement.dto.Branch;

public class BranchController {
	public static void main(String[] args) {
		BranchDao dao = new BranchDao();
		Branch branch = new Branch();
		branch.setArea("Marathalli");
		branch.setName("Apollo_Marathalli");
		branch.setWebsite("www.apollomarathalli.com");
		branch.setEmail("apollomarathalli@gmail.com");
		dao.saveBranchByHospital(1, branch);
	}
}
