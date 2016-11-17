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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.PrePersist;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SecondaryTable;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Autowired;


@Entity
@Table(name="PHONE_DETAILS")
@NamedQueries({
	@NamedQuery(name = "PhoneEntity.findAll", query = "SELECT p from PhoneEntity p")
})
public class PhoneEntity {
	
	/*@PrePersist
	private void generateSecret(){
		this.setId(UUID.randomUUID().toString());
	}
	*/
	
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Id
	@Column(name = "ID", length=8, unique = true, nullable = false)
	private int id;
	
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
	
    public int getId() {
		return id;
	}
	public void setId(int id) {
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
	public AddressEntity getAddress() {
		return address;
	}
	public void setAddress(AddressEntity addr) {
		this.address = addr;
	}
	
	
	public List<UserEntity> getUsers() {
		return users;
	}
	public void setUsers(List<UserEntity> users) {
		this.users = users;
	}
	@Override
	public String toString() {
        return "PhoneEntity id: " + getId() + " number: " + getNumber() +
               " is at location " + getAddress();
    }
	


}
