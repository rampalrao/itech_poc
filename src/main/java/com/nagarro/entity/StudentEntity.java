package com.nagarro.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "STUDENT")
public class StudentEntity {
	@Id
	@Column(name = "STUDENT_ID")
	@GeneratedValue
	private Long studentid;
	@Column(name = "FIRSTNAME")
	private String firstname;
	@Column(name = "LASTNAME")
	private String lastname;
	@Column(name = "EMAIL")
	private String email;
	@Column(name = "TELEPHONE")
	private String telephone;

	@OneToOne(mappedBy = "studentEntity", cascade = CascadeType.ALL)
	private AddressEntity addressEntity;

	@OneToMany(mappedBy = "studentEntity", cascade=CascadeType.ALL)
	private Set<CarEntity> cars = new HashSet<CarEntity>();

	public Long getStudentid() {
		return studentid;
	}

	public void setStudentid(Long studentid) {
		this.studentid = studentid;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public AddressEntity getAddressEntity() {
		return addressEntity;
	}

	public void setAddressEntity(AddressEntity addressEntity) {
		this.addressEntity = addressEntity;
	}

	public Set<CarEntity> getCars() {
		return cars;
	}

	public void setCars(Set<CarEntity> cars) {
		this.cars = cars;
	}

}
