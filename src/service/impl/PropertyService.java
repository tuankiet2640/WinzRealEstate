package service.impl;

import entity.*;

import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PropertyService implements Serializable {
    private static final Scanner scanner;
    private static int propertyId;
    private static List<Property> propertyList;
    private static File PROPERTY_DATA_FILE= new File("src/files/propertydata.txt");


    static {
        scanner = new Scanner(System.in);
        propertyId=2000;
        propertyList= new ArrayList<>();
    }
    public static void createGroundProperty(User user) {
        propertyId++;
        System.out.println("Nhập tên bds: ");
        String propertyTitle= scanner.nextLine();

        Address address= chooseAddress();

        System.out.println("Nhập giá mong muoons: ");
        long propertyPrice= scanner.nextLong();
        scanner.nextLine();

        System.out.println("Nhập diện tích: ");
        long area= scanner.nextLong();

        System.out.println("Nhập số lượng bể bơi: ");
        int numberOfPool= scanner.nextInt();
        scanner.nextLine();

        Property property= new GroundProperty(propertyId,propertyTitle, address, propertyPrice, area, numberOfPool);

        List<Property> properties= ((Seller) user).getProperties();
        properties.add(property);
        propertyList.add(property);
    }

    private static Address chooseAddress() {
        System.out.println("Nhập tên quận: ");
        String district= scanner.nextLine();

        System.out.println("Nhập tên thành phố: ");
        String city = scanner.nextLine();

        System.out.println("Nhập số nhà: ");
        String houseNumber= scanner.nextLine();

        Address address= new Address()
                .district(district)
                .city(city)
                .houseNumber(houseNumber);
        return address;
    }

    public static void createApartmentProperty(User user) {

        propertyId++;
        System.out.println("Nhập tên bds: ");
        String propertyTitle= scanner.nextLine();

        Address address= chooseAddress();

        System.out.println("Nhập giá mong muoons: ");
        long propertyPrice= scanner.nextLong();
        scanner.nextLine();

        System.out.println("Nhập diện tích: ");
        long area= scanner.nextLong();

        System.out.println("số phòng: ");
        int apaprtmentNumber = scanner.nextInt();
        scanner.nextLine();

        Property property= new ApartmentProperty(propertyId,propertyTitle, address, propertyPrice, area, apaprtmentNumber);

        List<Property> properties= ((Seller) user).getProperties();
        properties.add(property);
        propertyList.add(property);

    }

    public static void displayPropertyList(){
        for (Property property: propertyList){
            System.out.println(property);
        }
    }
    public static Property findPropertyById(int propertyId){
        for (Property property:propertyList){
            if (propertyId==property.getPropertyId()){
                return property;
            }
        }
        return null;
    }
    public static User propertySellerInfo(Property property) {
        List<User> users= UserService.getUsers();
        for (User user : users) {
            if (user instanceof Seller) {
                Seller seller = (Seller) user;

                List<Property> properties= seller.getProperties();
                for (Property property1:properties){
                    if (property1.getPropertyId()==property.getPropertyId()){
                        return seller;
                    }
                }
            }
        }

        return null;
    }
    public static List<Property> getPropertyList() {
        return propertyList;
    }

    public static void setPropertyList(List<Property> propertyList) {
        PropertyService.propertyList = propertyList;
    }

    public static File getPropertyDataFile() {
        return PROPERTY_DATA_FILE;
    }


}
