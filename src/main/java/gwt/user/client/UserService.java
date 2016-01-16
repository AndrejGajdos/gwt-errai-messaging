package gwt.user.client;

import gwt.user.client.model.User;

import java.util.List;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("userService")
public interface UserService extends RemoteService {
	List<User> getUserList();
	User getUser(String id);
} 
