package entity;

public class Seller extends User {
    private String phoneNumber;
    public Seller(int userId, String username,String password,String phoneNumber){
        super (userId,username,password);
        this.phoneNumber=phoneNumber;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
