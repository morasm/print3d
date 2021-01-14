package com.moras.print3d.backend.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moras.print3d.backend.entity.PrintOrder;
import com.moras.print3d.backend.repository.PrintOrderRepository;

@Service
public class PrintOrderServiceImpl implements PrintOrderService {
	
	private PrintOrderRepository printOrderRepository;
	
	@Autowired
	public PrintOrderServiceImpl(PrintOrderRepository thePrintOrderRepository) {
		printOrderRepository = thePrintOrderRepository;
	}

	@Override
	public List<PrintOrder> findAll() {
		
		return printOrderRepository.findAll();
	}
	
	@Override
	public List<PrintOrder> findByClient() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PrintOrder findById(int theId) {
		Optional <PrintOrder> result = printOrderRepository.findById(theId);
		PrintOrder thePrintOrder = null;
		if(result.isPresent()) {
			thePrintOrder = result.get();
		}else {
			throw new RuntimeException("Id: " + theId + " not found.");
		}
		
		return thePrintOrder;
	}

	@Override
	public void save(PrintOrder thePrintOrder) {
		printOrderRepository.save(thePrintOrder);
//		System.out.println(thePrintOrder);
	}


}
