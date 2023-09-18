package entity;

import java.io.Serializable;

public class Buyer extends User implements Serializable {
    private String email;
    public Buyer(int userId, String username,String password,String email){
        super (userId,username,password);
        this.email=email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
