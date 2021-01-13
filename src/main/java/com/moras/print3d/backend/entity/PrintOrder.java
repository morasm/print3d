package com.moras.print3d.backend.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PrintOrder")
public class PrintOrder {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "orderId")
	private int orderId;
	
//	private ClientProfile clientProfile;
	
//	private List<FileData> files;
	
	@Enumerated(EnumType.STRING)
	@Column(name= "orderStatus", length = 20)
	private OrderStatus orderStatus;

	public PrintOrder() {};
	
	public PrintOrder(int orderId, OrderStatus orderStatus) {
		this.orderId = orderId;
		//, ClientProfile clientProfile, List<FileData> files
//		this.clientProfile = clientProfile;
//		this.files = files;
		this.orderStatus = orderStatus;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

//	public ClientProfile getClientProfile() {
//		return clientProfile;
//	}
//
//	public void setClientProfile(ClientProfile clientProfile) {
//		this.clientProfile = clientProfile;
//	}
//
//	public List<FileData> getFiles() {
//		return files;
//	}
//
//	public void setFiles(List<FileData> files) {
//		this.files = files;
//	}

	public OrderStatus getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(OrderStatus orderStatus) {
		this.orderStatus = orderStatus;
	}

	@Override
	public String toString() {
		return "PrintOrder [orderId=" + orderId //+ ", clientProfile=" + clientProfile + ", files=" + files
				+ ", orderStatus=" + orderStatus + "]";
	}
	
}
