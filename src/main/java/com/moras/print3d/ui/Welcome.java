package com.moras.print3d.ui;

import com.moras.print3d.backend.entity.ClientProfile;
import com.moras.print3d.backend.service.ClientProfileService;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.EmailField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.BeanValidationBinder;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@Route(value = "", layout = MainLayout.class)
@PageTitle("Welcome | 3D Printing Service")
public class Welcome extends FormLayout{
	
	H2 header = new H2("Witamy na stronie 3D Printing");
	Component tn1 = new Span("Szanowni Państwo, zapraszamy do skorzystania z naszych usług.");
	Component tn2 = new Span("W celu zlecenia wydruku nalezy się zalogować i załadować plik STL");
	
	public Welcome() {
		VerticalLayout myPage = new VerticalLayout(header);
		myPage.add(tn1, tn2);
	add(myPage);
		
	}


}
