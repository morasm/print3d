package com.moras.print3d.ui;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.EmailField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@Route(value = "client", layout = MainLayout.class)
@PageTitle("Client profile | 3D Printing Service")
public class ClientProfileForm extends FormLayout{

	TextField clientName = new TextField("Client name");
	EmailField emailAddress = new EmailField("Email");
	
	Button save = new Button("Save");
	Button cancel = new Button("Cancel");
	
	public ClientProfileForm() {
		addClassName("client-form");
		add(clientName,emailAddress, createButtonsLayout());
	}

	private HorizontalLayout createButtonsLayout() {
		save.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
		cancel.addThemeVariants(ButtonVariant.LUMO_TERTIARY);
		return new HorizontalLayout(save, cancel);
	}
	
}
