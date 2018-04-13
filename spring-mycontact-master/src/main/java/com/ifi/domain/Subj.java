package com.ifi.domain;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;
@Entity
@Table(name ="subj")
public class Subj implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "idsub", nullable = false)
	private int idsub;
	
	@NotEmpty
	@Column(name ="tenmon",nullable = false)
	private String tenmon;
	
	@Column(name = "giaovien")
	private String giaovien;
	
	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "subj")
	private Set<Student> student;
	
	
	

//	public List<Subj> getSubj() {
//		return subj;
//	}
//
//	public void setSubj(List<Subj> subj) {
//		this.subj = subj;
//	}

	public Subj(int idsub, String tenmon, String giaovien) {
		super();
		this.idsub = idsub;
		this.tenmon = tenmon;
		this.giaovien = giaovien;
	}

	public Subj() {
		super();
	}

	public int getIdsub() {
		return idsub;
	}

	public void setIdsub(int idsub) {
		this.idsub = idsub;
	}

	public String getTenmon() {
		return tenmon;
	}

	public void setTenmon(String tenmon) {
		this.tenmon = tenmon;
	}

	public String getGiaovien() {
		return giaovien;
	}

	public void setGiaovien(String giaovien) {
		this.giaovien = giaovien;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}

