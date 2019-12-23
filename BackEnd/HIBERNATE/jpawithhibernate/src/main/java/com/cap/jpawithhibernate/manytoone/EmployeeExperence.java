package com.cap.jpawithhibernate.manytoone;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.cap.jpawithhibernate.onetoone.Employee;

@Entity
@Table(name="emp_exp")
public class EmployeeExperence {
	@Id
	@Column
	private int exp_id;
	@Column
	private String compname;
	@Column
	private int duration;

	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="eid")
	private Employee employee;

	public int getExp_id() {
		return exp_id;
	}

	public void setExp_id(int exp_id) {
		this.exp_id = exp_id;
	}

	public String getCompname() {
		return compname;
	}

	public void setCompname(String compname) {
		this.compname = compname;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	
	
	

}
