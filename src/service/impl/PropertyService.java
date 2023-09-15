package service.impl;

import entity.GroundProperty;
import entity.Property;
import entity.Seller;
import entity.User;

import java.util.List;

public class PropertyService {

    public static void createGroundProperty(User user) {


 //       Property property= new GroundProperty();

        List<Property> properties= ((Seller) user).getProperties();
    }

    public static void createApartmentProperty(User user) {
    }
}
