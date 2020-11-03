package com.moras.print3d.ui;

import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.RouterLink;

public class MainLayout extends AppLayout {
	public MainLayout() {
		createHeader();
		createDrawer();
	}

	private void createHeader() {
		H1 logo = new H1("3D Printing service");
		logo.addClassName("logo");
		
		HorizontalLayout header = new HorizontalLayout(new DrawerToggle(), logo);
		header.setDefaultVerticalComponentAlignment(
				FlexComponent.Alignment.CENTER);
		header.setWidth("100%");
		header.addClassName("header");
		addToNavbar(header);
	}

	private void createDrawer() {
		addToDrawer(new VerticalLayout(
			new RouterLink("New order", OrderListView.class),
			new RouterLink("Orders list", OrderListView.class),
			new RouterLink("Client profile", ClientProfileForm.class)
		));
		
	}

}
