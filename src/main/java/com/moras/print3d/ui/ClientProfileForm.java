package com.moras.print3d.ui;

import org.springframework.beans.factory.annotation.Autowired;

import com.moras.print3d.backend.entity.ClientProfile;
import com.moras.print3d.backend.service.ClientProfileService;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.EmailField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.BeanValidationBinder;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@Route(value = "client", layout = MainLayout.class)
@PageTitle("Client profile | 3D Printing Service")
public class ClientProfileForm extends FormLayout{

	private ClientProfileService clientProfileService;
	private ClientProfile clientProfile;
	TextField clientName = new TextField("Client name");
	EmailField emailAddress = new EmailField("Email");
	
	Button save = new Button("Save");
	Button cancel = new Button("Cancel");
	
	Binder<ClientProfile> binder = new Binder<>(ClientProfile.class);
	
	public ClientProfileForm(ClientProfileService theClientProfileService) {
		clientProfileService = theClientProfileService;
		clientProfile = new ClientProfile("","");
		addClassName("client-form");
		add(clientName, emailAddress, createButtonsLayout());
		binder.bindInstanceFields(this);
		
		save.addClickListener(e -> save());
	}

	private HorizontalLayout createButtonsLayout() {
		save.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
		cancel.addThemeVariants(ButtonVariant.LUMO_TERTIARY);
		return new HorizontalLayout(save, cancel);
	}
	
//	public void setClientProfile(ClientProfile clientProfile) {
//		this.clientProfile = clientProfile;
//		binder.setBean(clientProfile);
//	}
	
	private void save() {
		System.out.println(clientProfile);
		clientProfileService.save(clientProfile);
		setVisible(false);
	}
}
