package com.moras.print3d.backend.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ClientProfile")
public class ClientProfile {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "clientId")
	private int clientId;
	
	@Column(name = "clientName")
	private String clientName;
	
	@Column(name = "emailAddress")
	private String emailAddress;
	
	public ClientProfile() {}

	public ClientProfile(int clientId, String clientName, String emailAddress) {
		this.clientId = clientId;
		this.clientName = clientName;
		this.emailAddress = emailAddress;
	}
	public ClientProfile(String clientName, String emailAddress) {
		this.clientName = clientName;
		this.emailAddress = emailAddress;
	}

	public int getClientId() {
		return clientId;
	}

	public void setClientId(int clientId) {
		this.clientId = clientId;
	}

	public String getClientName() {
		return clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	@Override
	public String toString() {
		return "ClientProfile [clientId=" + clientId + ", clientName=" + clientName + ", emailAddress=" + emailAddress
				+ "]";
	}
	
}
