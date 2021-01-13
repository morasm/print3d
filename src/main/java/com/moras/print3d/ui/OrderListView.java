package com.moras.print3d.ui;



import java.util.ArrayList;
import java.util.List;

import com.moras.print3d.backend.entity.PrintOrder;
import com.moras.print3d.backend.service.PrintOrderService;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@Route(value = "orders-list", layout = MainLayout.class)
@PageTitle("Orders | 3D Printing Service")
public class OrderListView extends VerticalLayout {
	
	private PrintOrderService printOrderService;
	private Grid<PrintOrder> grid = new Grid<>(PrintOrder.class);
	
	public OrderListView(PrintOrderService thePrintOrderService) {
		this.printOrderService = thePrintOrderService;
		setSizeFull();
		configureGrid();
		add(grid);
		updateList();
	}
	private void updateList() {
		if(printOrderService.findAll() != null) {
		grid.setItems(printOrderService.findAll());}
		
	}
	private void configureGrid() {
		grid.setSizeFull();
		grid.setColumns("orderId", "orderStatus");
		
	}
}

