package gwt.user.server;

import org.jboss.errai.bus.client.api.base.MessageBuilder;
import org.jboss.errai.bus.client.api.messaging.Message;
import org.jboss.errai.bus.client.api.messaging.MessageBus;
import org.jboss.errai.bus.client.api.messaging.MessageCallback;
import org.jboss.errai.bus.client.api.messaging.RequestDispatcher;
import org.jboss.errai.bus.server.annotations.Service;
import org.jboss.errai.bus.server.service.ErraiService;
import org.jboss.errai.bus.server.service.ErraiServiceSingleton;

import com.google.inject.Inject;

@Service
public class MessageController implements MessageCallback{

	// https://docs.jboss.org/author/display/ERRAI/Dependency+Injection
	@Inject
	private RequestDispatcher dispatcher;
	
	private MessageBus bus;
	
	public MessageController() {
		ErraiService<?> service = ErraiServiceSingleton.getService();
		this.bus = service.getBus();
	}

	public void sendMessage(){
		MessageBuilder.createMessage()
		.toSubject("ClientService")
		.signalling()
		.with("text", "Hi There")
		.noErrorHandling()
		.sendNowWith(this.bus);   
	}

	public void callback(Message message) {
		System.out.println("MessageController received message");
		this.sendMessage();
	}

}
