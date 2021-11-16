package model;

public class User {
    private int User_ID;
    private String User_Name;
    private String Password;

    public int getUser_ID() {
        return User_ID;
    }

    public String getUser_Name() {
        return User_Name;
    }

    public String getPassword() {
        return Password;
    }

    public void setUser_ID(int user_ID) {
        User_ID = user_ID;
    }

    public void setUser_Name(String user_Name) {
        User_Name = user_Name;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public User(int user_id, String user_name, String password) {
        User_ID = user_id;
        User_Name = user_name;
        Password = password;
    }
}
