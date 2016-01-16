package gwt.user.client;

import gwt.user.client.model.User;

import java.util.ArrayList;
import java.util.List;

public class DataSource {
	
	private final List<User> users;
	  private List<String> header;

	  public DataSource(List<User> users) {
	    header = new ArrayList<String>();
	    header.add("Id");
	    header.add("Name");
	    header.add("Number of Hits");
	    this.users = users;
	  }

	  public List<User> getUsers() {
	    return users;
	  }

	  public List<String> getTableHeader() {
	    return header;
	  }

}
