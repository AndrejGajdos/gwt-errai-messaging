package gwt.user.client.model;

import java.io.Serializable;

public class User implements Serializable {

  private static final long serialVersionUID = 7771707747802776175L;
  private String id;
  private String username;
  private String numberOfHits;

  public User(){}
  
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getNumberOfHits() {
    return numberOfHits;
  }

  public void setNumberOfHits(String numberOfHits) {
    this.numberOfHits = numberOfHits;
  }
} 
