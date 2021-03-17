package com.nt.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;

import lombok.Data;
@Entity
@Data
@Table(name ="CONTACT_DTLS ")
public class ContactEntity implements Serializable{
	
	@Id
	@GeneratedValue(strategy =GenerationType.AUTO)
	@Column(name="CONTACT_ID")
	private Integer contactId;
	@Column(name="CONTACT_NAME")
	private String contactName;
	@Column(name="CONTACT_EMAIL")
	private String contactEmail;
	@Column(name="CONTACT_NUMBER")
	private Long contactNumber;
	@CreationTimestamp
	@Temporal(TemporalType.DATE)
	@Column(name="CREATED_DATE",updatable = false)
	private Date createdDate;
	@Temporal(TemporalType.DATE)
	@UpdateTimestamp
	@Column(name="UPDATED_DATE",insertable = false)
	private Date updatedDate;

}
