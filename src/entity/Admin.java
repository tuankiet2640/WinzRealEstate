package entity;

import java.io.Serializable;

public class Admin extends User implements Serializable {
    private static final Admin admin;
    static {
        admin = new Admin(9999,"admin","admin");
    }
    private Admin(int userId, String username, String password){
        super(userId,username,password);
    }
    public static Admin getAdmin(){
                return admin;
    }
}
