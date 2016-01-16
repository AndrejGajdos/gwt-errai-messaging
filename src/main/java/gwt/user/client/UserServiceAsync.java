package gwt.user.client;

import gwt.user.client.model.User;

import java.util.List;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface UserServiceAsync {
	void getUserList(AsyncCallback<List<User>> callback);
	void getUser(String id, AsyncCallback<User> callback);
} 
