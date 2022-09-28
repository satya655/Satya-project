package com.jspider.hospitalmanagement.dto;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Encounter {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String cause;
	private String email;
	private long phoNo;
	
	@ManyToOne
	@JoinColumn(name="branchid")
	private Branch branch;
	
	@OneToMany(mappedBy = "encounter",cascade = CascadeType.ALL)
	private List<MedOrder> medOrder;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCause() {
		return cause;
	}

	public void setCause(String cause) {
		this.cause = cause;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getPhoNo() {
		return phoNo;
	}

	public void setPhoNo(long phoNo) {
		this.phoNo = phoNo;
	}

	public Branch getBranch() {
		return branch;
	}

	public void setBranch(Branch branch) {
		this.branch = branch;
	}

	public List<MedOrder> getMedOrder() {
		return medOrder;
	}

	public void setMedOrder(List<MedOrder> medOrder) {
		this.medOrder = medOrder;
	}
	
}
