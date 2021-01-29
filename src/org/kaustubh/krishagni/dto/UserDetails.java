package org.kaustubh.krishagni.dto;


import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.AttributeOverrides;
import javax.persistence.Embedded;

//import java.util.Date;

//import javax.persistence.Basic;
//import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
//import javax.persistence.Lob;
import javax.persistence.Table;
//import javax.persistence.Temporal;
//import javax.persistence.TemporalType;
//import javax.persistence.Transient;
import javax.persistence.Transient;

import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

@Entity 
@Table (name="USER_DETAILS")
public class UserDetails {
	
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private int userId;
	private String userName;
	@ElementCollection(fetch=FetchType.EAGER)
	@JoinTable(name="USER_ADDRESS",
		joinColumns=@JoinColumn(name="USER_ID")	
	)
	
	private Collection<Address> listOfAddresses = new ArrayList<Address>();
	/*@Temporal (TemporalType.DATE)
	private Date joinedDate;
	private String Address;
	@Lob
	private String description;*/
	
	
	public int getUserId() {
		return userId;
	}
	public void setListOfAddresses(Collection<Address> listOfAddresses) {
		this.listOfAddresses = listOfAddresses;
	}
	public Collection<Address> getListOfAddresses() {
		return listOfAddresses;
	}
	public void setListOfAddresses(Set<Address> listOfAddresses) {
		this.listOfAddresses = listOfAddresses;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	/*public Date getJoinedDate() {
		return joinedDate;
	}
	public void setJoinedDate(Date joinedDate) {
		this.joinedDate = joinedDate;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}*/
	
}
