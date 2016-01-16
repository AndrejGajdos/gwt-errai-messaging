package gwt.user.client;

import gwt.user.client.model.User;

import java.util.List;

import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;

public class UserCallback implements AsyncCallback<List<User>> {

	  private MyTable table;

	  public UserCallback(MyTable table) {
	    this.table = table;
	  }

	  public void onFailure(Throwable caught) {
	    Window.alert(caught.getMessage());
	  }

	  public void onSuccess(List<User> result) {
	    List<User> users = result;
	    DataSource datasource = new DataSource(users);
	    table.setInput(datasource);
	    for (User user : users) {
	      System.out.println(user.getUsername());
	    }
	  }
}
