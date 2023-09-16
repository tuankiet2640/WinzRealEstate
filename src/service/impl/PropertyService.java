package service.impl;

import entity.*;

import java.util.List;
import java.util.Scanner;

public class PropertyService {
    private static final Scanner scanner;
    private static int propertyId;

    static {
        scanner = new Scanner(System.in);
        propertyId=2000;
    }
    public static void createGroundProperty(User user) {
        int id=addingPropertyId();

        System.out.println("Nhập tên bds: ");
        String propertyTitle= scanner.nextLine();

        Address address= chooseAddress();

        System.out.println("Nhập giá mong muoons: ");
        long propertyPrice= scanner.nextLong();
        scanner.nextLine();

        System.out.println("Nhập diện tích: ");
        long area= scanner.nextLong();

        boolean hasPool=false;
        System.out.println("Nhập số lượng bể bơi: ");
        int numberOfPool= scanner.nextInt();
        scanner.nextLine();

        Property property= new GroundProperty(id,propertyTitle, address, propertyPrice, area, numberOfPool);

        List<Property> properties= ((Seller) user).getProperties();
        properties.add(property);
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

        int id=addingPropertyId();

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

        Property property= new ApartmentProperty(id,propertyTitle, address, propertyPrice, area, apaprtmentNumber);

        List<Property> properties= ((Seller) user).getProperties();
        properties.add(property);
    }
    private static int addingPropertyId(){
        return propertyId++;
    }

}
