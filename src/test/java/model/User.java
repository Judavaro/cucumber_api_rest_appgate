package model;

public class User {

  public String id;
  public String first_name;
  public String last_name;
  public String email;
  public String avatar;

  public void User(first_name, last_name, email, avatar){
    this.first_name = first_name;
    this.last_name = last_name;
    this.email = email;
    this.avatar = avatar;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getFirst_name() {
    return first_name;
  }

  public void setFirst_name(String first_name) {
    this.first_name = first_name;
  }

  public String getLast_name() {
    return last_name;
  }

  public void setLast_name(String last_name) {
    this.last_name = last_name;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getAvatar() {
    return avatar;
  }

  public void setAvatar(String avatar) {
    this.avatar = avatar;
  }
}
