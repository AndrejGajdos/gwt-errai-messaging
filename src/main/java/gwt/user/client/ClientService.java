package gwt.user.client;

import org.jboss.errai.bus.client.ErraiBus;
import org.jboss.errai.bus.client.api.base.MessageBuilder;
import org.jboss.errai.bus.client.api.messaging.Message;
import org.jboss.errai.bus.client.api.messaging.MessageBus;
import org.jboss.errai.bus.client.api.messaging.MessageCallback;
import org.jboss.errai.bus.client.api.messaging.RequestDispatcher;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.ServiceDefTarget;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.VerticalPanel;

public class ClientService implements EntryPoint{
	
	private MyTable table;
	private RequestDispatcher dispatcher = ErraiBus.getDispatcher();
	private MessageBus bus = ErraiBus.get();
	
	private RequestDispatcher getDispatcher(){
		return this.dispatcher;
	}

	  public void onModuleLoad() {
		  
	    table = new MyTable(null);

	    Button button = new Button("Click me");

	    // We can add style names
	    button.addStyleName("pc-template-btn");
	    // or we can set an id on a specific element for styling

	    VerticalPanel vPanel = new VerticalPanel();
	    vPanel.setWidth("100%");
	    vPanel.setHorizontalAlignment(VerticalPanel.ALIGN_CENTER);
	    vPanel.add(button);

	    vPanel.add(table);

	    // add table and button to the RootPanel
	    RootPanel.get().add(vPanel);

	    // create the dialog box
	    final DialogBox dialogBox = new DialogBox();
	    dialogBox.setText("Welcome to GWT Server Communication!");
	    dialogBox.setAnimationEnabled(true);
	    Button closeButton = new Button("close");
	    VerticalPanel dialogVPanel = new VerticalPanel();
	    dialogVPanel.setWidth("100%");
	    dialogVPanel.setHorizontalAlignment(VerticalPanel.ALIGN_CENTER);
	    dialogVPanel.add(closeButton);

	    closeButton.addClickHandler(new ClickHandler() {
	      public void onClick(ClickEvent event) {
	        dialogBox.hide();
	      }
	    });

	    // Set the contents of the Widget
	    dialogBox.setWidget(dialogVPanel);

	    button.addClickHandler(new ClickHandler() {
	      public void onClick(ClickEvent event) {
	        UserServiceAsync service = (UserServiceAsync) GWT.create(UserService.class);
	        ServiceDefTarget serviceDef = (ServiceDefTarget) service;
	        serviceDef.setServiceEntryPoint(GWT.getModuleBaseURL() + "userService");
	        UserCallback myUserCallback = new UserCallback(table);
	        
//	        MessageBuilder.createMessage()
//	          .toSubject("MessageController") 
//	          .signalling() 
//	          .noErrorHandling()
//	          .sendNowWith(getDispatcher());
	        
	        service.getUserList(myUserCallback);
	      }
	    });
	    
	    bus.subscribe("ClientService", new MessageCallback() {

			public void callback(Message message) {
				Window.alert("ClientService message is received. " + message.get(String.class, "text"));
			}

	      });

	  }

}
