package edu.sjsu.cmpe275.lab2.Entity;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SecondaryTable;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.JoinColumn;

import org.springframework.beans.factory.annotation.Autowired;

@Entity
@Table(name = "USER_DETAILS")

public class User {
	@PrePersist
	private void generateSecret(){
		this.setId(UUID.randomUUID().toString());
	}

	@Id
	@Column(name = "id", nullable = false, unique=true)
	private String id;

	@Column(name = "FIRST_NAME")
	private String firstname;
	@Column(name = "LAST_NAME")
	private String lastname;
	@Column(name = "TITLE")
	private String title;

	@Autowired
	@Embedded
	/*@AttributeOverrides({
		@AttributeOverride(name="street", column=@Column(name="street",table="address")),
		@AttributeOverride(name="city", column=@Column(name="city", table="address")),
		@AttributeOverride(name="state", column=@Column(name="state", table="address")),
		@AttributeOverride(name="zip",
		column=@Column(name="zip_code", table="address"))
	})*/
	private Address address;

	@ManyToMany(cascade = CascadeType.PERSIST)
	@JoinTable(name="USER_PHONE",
	joinColumns=@JoinColumn(name="USER_ID", referencedColumnName="ID"),
	inverseJoinColumns=@JoinColumn(name="PHONE_ID", referencedColumnName="ID"))
	//@ManyToMany(mappedBy="users")
	private List<Phone> phones=new ArrayList<Phone>();


	public List<Phone> getPhones() {
		return phones;
	}

	public void setPhones(List<Phone> phones) {
		this.phones = phones;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address addr) {
		this.address = addr;
	}

	

	@Override
	public String toString() {
		return "User id: " + getId() + " firstname: " +getFirstname() +
				" lastname: "+ getLastname()+ " is at location " + getAddress();
	}

}
