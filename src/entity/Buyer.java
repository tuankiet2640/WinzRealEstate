package entity;

import java.io.Serializable;

public class Buyer extends User implements Serializable {
    private String email;
    public Buyer(int userId, String username,String password,String email){
        super (userId,username,password);
        this.email=email;
    }


}
