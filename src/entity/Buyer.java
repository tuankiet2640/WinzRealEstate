package entity;

public class Buyer extends User {
    private String email;
    public Buyer(int userId, String username,String password,String email){
        super (userId,username,password);
        this.email=email;
    }


}
