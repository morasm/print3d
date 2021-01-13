package com.moras.print3d.backend.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "client_profile")
public class ClientProfile {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "clientId")
	private int clientId;
	
	@Column(name = "clientName")
	private String clientName;
	
	@Column(name = "emailAddress")
	private String emailAddress;
	
	@OneToMany(mappedBy = "clientProfile", fetch = FetchType.LAZY)
	private List<PrintOrder> clientOrders;
	
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

	
	public List<PrintOrder> getClientOrders() {
		return clientOrders;
	}

	public void setClientOrders(List<PrintOrder> clientOrders) {
		this.clientOrders = clientOrders;
	}

	@Override
	public String toString() {
		return "ClientProfile [clientId=" + clientId + ", clientName=" + clientName + ", emailAddress=" + emailAddress
				+ "]";
	}
	
}
