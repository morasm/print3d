package com.moras.print3d.ui;



import java.util.ArrayList;
import java.util.List;

import com.moras.print3d.backend.entity.ClientProfile;
import com.moras.print3d.backend.entity.PrintOrder;
import com.moras.print3d.backend.service.ClientProfileService;
import com.moras.print3d.backend.service.PrintOrderService;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@Route(value = "clients-list", layout = MainLayout.class)
@PageTitle("Clients | 3D Printing Service")
public class ClientsListView extends VerticalLayout {
	
	private ClientProfileService clientProfileService;
	private Grid<ClientProfile> grid = new Grid<>(ClientProfile.class);
	
	public ClientsListView(ClientProfileService theClientProfileService) {
		this.clientProfileService = theClientProfileService;
		setSizeFull();
		configureGrid();
		add(grid);
		updateList();
	}
	private void updateList() {
		if(clientProfileService.findAll() != null) {
		grid.setItems(clientProfileService.findAll());}
		
	}
	private void configureGrid() {
		grid.setSizeFull();
		grid.setColumns("clientId", "clientName");
		
	}
}

