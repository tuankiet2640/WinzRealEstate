package entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Seller extends User implements Serializable {
    private int phoneNumber;
    List<Property> properties= new ArrayList<>();
    public Seller(int userId, String username,String password,int phoneNumber){
        super (userId,username,password);
        this.phoneNumber=phoneNumber;
    }

    public List<Property> getProperties() {
        return properties;
    }

    public void setProperties(List<Property> properties) {
        this.properties = properties;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
