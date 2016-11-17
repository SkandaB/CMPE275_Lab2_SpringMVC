package edu.sjsu.cmpe275.lab2.Entity;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SecondaryTable;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Autowired;


@Entity
@Table(name="PHONE_DETAILS")

public class Phone {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
    private Long id;
	
	@Column(name = "NUMBER",unique=true)
    private String number;  // Note, phone numbers must be unique
	@Column(name = "DESCRIPTION")
	private String description;
    
    @Autowired
	@Embedded
    private Address address;
    
    
    @ManyToMany(mappedBy="phones")
    /*@OneToMany(cascade = CascadeType.ALL)
	@JoinTable(name="USER_PHONE",
	joinColumns={@JoinColumn(name="USER_ID", referencedColumnName="ID")},
	inverseJoinColumns={@JoinColumn(name="PHONE_ID", referencedColumnName="ID")})*/
    private List<User> users = new ArrayList<User>();
	
    public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address addr) {
		this.address = addr;
	}
	
	
	public List<User> getUsers() {
		return users;
	}
	public void setUsers(List<User> users) {
		System.out.println("here in set");
		this.users = users;
		
		System.out.println("after persisting" + this.users.get(0));
	}
	@Override
	public String toString() {
        return "Phone id: " + getId() + " number: " + getNumber() +
               " is at location " + getAddress();
    }
	


}
