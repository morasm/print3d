package com.moras.print3d.ui.login;

import java.util.Collection;
import java.util.Collections;

import com.moras.print3d.ui.MainLayout;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.login.LoginForm;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.BeforeEnterEvent;
import com.vaadin.flow.router.BeforeEnterObserver;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@Route(value = "login", layout = MainLayout.class)
@PageTitle("Login | 3D Printing Service")
public class LoginView extends VerticalLayout implements BeforeEnterObserver{
	
	LoginForm login = new LoginForm();
	
	public LoginView() {
		setSizeFull();
		setJustifyContentMode(JustifyContentMode.CENTER);
		setAlignItems(Alignment.CENTER);
		
		login.setAction("login");
		add(
			new H1("Login - 3D Printing Service"),
			login
		);
	}

	@Override
	public void beforeEnter(BeforeEnterEvent event) {
		if(!event.getLocation()
				.getQueryParameters()
				.getParameters()
				.getOrDefault("error", Collections.emptyList())
				.isEmpty()) {
			login.setError(true);
		}
		
	}

}
