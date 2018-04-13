package com.ifi.domain;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;


@Entity
@Table(name = "contact")
public class Student implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private int id;

    @NotEmpty
    @Column(name = "name", nullable = false)
    private String name;

    @Email
    @Column(name = "email")
    private String email;

    @Column(name = "phone")
    private String phone;
    
    @Column(name = "monhoc") 
    private String monhoc;
    
    
    
    
    
	public Student(int id, String name, String email, String phone, String monhoc) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.monhoc = monhoc;
	}
	public Student() {
		super();
	}
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
   	@JoinTable(name = "lienket", joinColumns = {
   			@JoinColumn(name = "id") }, inverseJoinColumns = {
   					@JoinColumn(name = "idsub") })
	private Set<Subj> subj;
	
	
	
//	public List<Student> getContact() {
//		return contact;
//	}
//	public void setContact(List<Student> contact) {
//		this.contact = contact;
//	}
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getMonhoc() {
		return monhoc;
	}
	public void setMonhoc(String monhoc) {
		this.monhoc = monhoc;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

    

}