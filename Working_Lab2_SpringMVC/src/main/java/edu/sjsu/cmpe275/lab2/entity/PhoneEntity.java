package edu.sjsu.cmpe275.lab2.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.PrePersist;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SecondaryTable;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Autowired;


@Entity
@Table(name="PHONE_DETAILS")
public class PhoneEntity {
	
	/*@PrePersist
	private void generateSecret(){
		this.setId(UUID.randomUUID().toString());
	}
	*/
	
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Id
	@Column(name = "ID", length=8, unique = true, nullable = false)
	private Integer id;
	
	@Column(name = "NUMBER",unique=true,length=10)
    private String number;  // Note, phone numbers must be unique
	
	@Column(name = "DESCRIPTION")
	private String description;
    
    @Autowired
	@Embedded
   /* @AttributeOverrides({
        @AttributeOverride(name="street", column=@Column(name="street",table="address")),
        @AttributeOverride(name="city", column=@Column(name="city", table="address")),
        @AttributeOverride(name="state", column=@Column(name="state", table="address")),
        @AttributeOverride(name="zip",
                           column=@Column(name="zip_code", table="address"))
    })*/
    private AddressEntity address;
    
    @ManyToMany(mappedBy="phones")
    private List<UserEntity> users = new ArrayList<UserEntity>();
	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * @return the number
	 */
	public String getNumber() {
		return number;
	}
	/**
	 * @param number the number to set
	 */
	public void setNumber(String number) {
		this.number = number;
	}
	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	/**
	 * @return the address
	 */
	public AddressEntity getAddress() {
		return address;
	}
	/**
	 * @param address the address to set
	 */
	public void setAddress(AddressEntity address) {
		this.address = address;
	}
	/**
	 * @return the users
	 */
	public List<UserEntity> getUsers() {
		return users;
	}
	/**
	 * @param users the users to set
	 */
	public void setUsers(List<UserEntity> users) {
		this.users = users;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "PhoneEntity [id=" + id + ", number=" + number + ", description=" + description + ", address=" + address
				+ ", users=" + users + "]";
	}
	
	
    }
