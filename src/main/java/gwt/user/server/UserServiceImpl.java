package gwt.user.server;

import gwt.user.client.UserService;
import gwt.user.client.model.User;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

public class UserServiceImpl extends RemoteServiceServlet implements UserService{

	private static final long serialVersionUID = 1L;
	private List<User> userList = new ArrayList<User>();
	private MessageController messageController = new MessageController();
	
	public UserServiceImpl() {
		
		User user = new User();
		userList.add(user);
		user.setId("1");
	    user.setUsername("Peter");
	    user.setNumberOfHits("15");
	    userList.add(user);
		
	    user = new User();
	    user.setId("2");
	    user.setUsername("Hanz");
	    user.setNumberOfHits("25");
		userList.add(user);
		
	}
	
	public User getUser(String id) {
		for (Object object : userList) {
		  if (((User) object).getId().equals(id))
		    return ((User) object);
		}
		return null;
		
	}
	
	public List<User> getUserList() {
		messageController.sendMessage();
		return userList;
	}
	
} 

