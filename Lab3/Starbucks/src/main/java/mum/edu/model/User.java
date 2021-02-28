package mum.edu.model;

import java.io.Serializable;

public class User implements Serializable {
    private String name;
    private String password;

    public User(){}
    public User(String name, String password){
        this.name = name;
        this.password = password;
    };

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isEqual(User user) {
        return user.getName().equals(this.getName()) && user.getPassword().equals(this.getPassword());
    }
}
