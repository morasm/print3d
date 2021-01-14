package com.moras.print3d.ui;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;

import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;

import org.apache.commons.io.IOUtils;

import com.moras.print3d.backend.entity.ClientProfile;
import com.moras.print3d.backend.entity.OrderStatus;
import com.moras.print3d.backend.entity.PrintOrder;
import com.moras.print3d.backend.service.ClientProfileService;
import com.moras.print3d.backend.service.PrintOrderService;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.HasComponents;
import com.vaadin.flow.component.HtmlComponent;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.component.upload.Upload;
import com.vaadin.flow.component.upload.receivers.MemoryBuffer;
import com.vaadin.flow.component.upload.receivers.MultiFileMemoryBuffer;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.internal.MessageDigestUtil;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.StreamResource;

@Route(value = "new-order", layout = MainLayout.class)
@PageTitle("New order | 3D Printing Service")
public class OrderForm extends FormLayout {
	
	private PrintOrderService printOrderService;
	private PrintOrder printOrder;
	
	private ClientProfileService clientProfileService;
	
	
	private OrderStatus orderStatus;
	TextField clientId = new TextField("Client");
	Button save = new Button("Send");
	ComboBox<ClientProfile> clProfile = new ComboBox<>("Client");
	
	public OrderForm(PrintOrderService thePrintOrderService,
			ClientProfileService theClientProfileService) {
		Div output = new Div();
		printOrderService = thePrintOrderService;
		clientProfileService = theClientProfileService;
		
		clProfile.setItems(clientProfileService.findAll());
		clProfile.setItemLabelGenerator(ClientProfile::getClientName);
//		Binder<PrintOrder> binder = new Binder<>(PrintOrder.class);
		
		printOrder = new PrintOrder();

		clProfile.addValueChangeListener(e -> printOrder.setClientProfile(e.getValue()));
//		binder.setBean(printOrder);
		printOrder.setOrderStatus(OrderStatus.NEW);

        //@formatter:off
        // begin-source-example
        // source-example-heading: Simple in memory receiver for single file upload
        MemoryBuffer buffer = new MemoryBuffer();
        Upload upload = new Upload(buffer);
        upload.setAutoUpload(false);

        upload.addSucceededListener(event -> {
            Component component = createComponent(event.getMIMEType(),
                    event.getFileName(), buffer.getInputStream());

    		output.add(save); //countParts, 
            showOutput(event.getFileName(),  output); 

    		//component,
        });
        // end-source-example
        //@formatter:on


        add(clProfile, upload, output);
//        binder.bindInstanceFields(this);
        save.addClickListener(e -> save(printOrder));
	}

    
    private Component createComponent(String mimeType, String fileName,
            InputStream stream) {
        if (mimeType.startsWith("text")) {
          return createTextComponent(stream);
        } else if (mimeType.startsWith("image")) {
            Image image = new Image();
            try {

                byte[] bytes = IOUtils.toByteArray(stream);
                image.getElement().setAttribute("src", new StreamResource(
                        fileName, () -> new ByteArrayInputStream(bytes)));
                try (ImageInputStream in = ImageIO.createImageInputStream(
                        new ByteArrayInputStream(bytes))) {
                    final Iterator<ImageReader> readers = ImageIO
                            .getImageReaders(in);
                    if (readers.hasNext()) {
                        ImageReader reader = readers.next();
                        try {
                            reader.setInput(in);
                            image.setWidth(reader.getWidth(0) + "px");
                            image.setHeight(reader.getHeight(0) + "px");
                        } finally {
                            reader.dispose();
                        }
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            return image;
        }
        Div content = new Div();
        String text = String.format("Mime type: '%s'\nSHA-256 hash: '%s'",
                mimeType, MessageDigestUtil.sha256(stream.toString()));
        content.setText(text);
        return content;

    }

    private Component createTextComponent(InputStream stream) {
        String text;
        try {
            text = IOUtils.toString(stream, StandardCharsets.UTF_8);
        } catch (IOException e) {
            text = "exception reading stream";
        }
        return new Text(text);
      }
    
	  private void showOutput(String text, //Component content,
	            HasComponents outputContainer) {
	        HtmlComponent p = new HtmlComponent(Tag.P);
	        p.getElement().setText(text);
	        outputContainer.add(p);
	        //outputContainer.add(content);
	    }
	  
		private void save(PrintOrder tpo) {
			System.out.println(tpo);
			printOrderService.save(tpo);
			setVisible(false);
		}
}

