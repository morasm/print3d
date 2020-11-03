package com.moras.print3d.backend.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name = "FileData")
public class FileData {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "fileId")
	private int fileId;
	
	@Column(name = "fileName")
	private String fileName;
	
	@Lob
	@Column(name = "fileContent")
	private byte[] fileContent;
	
	@Column(name = "price")
	private float price;
	
	@Column(name = "isPrinted")
	private boolean isPrinted;
	
//	private PrintOrder printOrder;

	public FileData() {}

	public FileData(int fileId, String fileName, byte[] fileContent, float price, boolean isPrinted) {
		this.fileId = fileId;
		this.fileName = fileName;
		this.fileContent = fileContent;
		this.price = price;
		this.isPrinted = isPrinted;
	}

	public int getFileId() {
		return fileId;
	}

	public void setFileId(int fileId) {
		this.fileId = fileId;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public boolean isPrinted() {
		return isPrinted;
	}

	public void setPrinted(boolean isPrinted) {
		this.isPrinted = isPrinted;
	}

//	public PrintOrder getPrintOrder() {
//		return printOrder;
//	}
//
//	public void setPrintOrder(PrintOrder printOrder) {
//		this.printOrder = printOrder;
//	}
	

	public byte[] getFileContent() {
		return fileContent;
	}

	public void setFileContent(byte[] fileContent) {
		this.fileContent = fileContent;
	}

	@Override
	public String toString() {
		return "FileData [fileId=" + fileId + ", fileName=" + fileName + ", price=" + price + ", isPrinted=" + isPrinted
				+ "]";
	}
	
}
