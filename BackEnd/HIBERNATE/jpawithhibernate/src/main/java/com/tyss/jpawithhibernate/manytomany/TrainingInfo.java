package com.tyss.jpawithhibernate.manytomany;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.cap.jpawithhibernate.onetoone.Employee;

@Entity
@Table(name="TrainInfo")
public class TrainingInfo {
	@Id
	@Column
	private int tid;
	private String tname;
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name="trainig_employee",joinColumns=@JoinColumn(name="tid"),
	inverseJoinColumns=@JoinColumn(name="eid"))
	private List<Employee> elist;
	public int getTid() {
		return tid;
	}
	public void setTid(int tid) {
		this.tid = tid;
	}
	public String getTname() {
		return tname;
	}
	public void setTname(String tname) {
		this.tname = tname;
	}
	public List<Employee> getElist() {
		return elist;
	}
	public void setElist(List<Employee> elist) {
		this.elist = elist;
	}
	


}
