package com.moras.print3d.backend.service;

import java.util.List;

import com.moras.print3d.backend.entity.PrintOrder;

public interface PrintOrderService {

	public List<PrintOrder> findAll();
	
	public List<PrintOrder> findByClient();
	
	public PrintOrder findById(int theId);
	
	public void save(PrintOrder thePrintOrder);
	
}
