package service.impl;
import com.sun.tools.javac.Main;
import constants.Constants;
import entity.Property;
import entity.Seller;
import entity.User;

import java.io.Serializable;
import java.util.List;
import java.util.Scanner;

public class SellerService implements Serializable {
    private static final Scanner scanner;
    private  static List<User> users;

    static {
        scanner = new Scanner(System.in);
        users= UserService.getUsers();
    }

    public void register() {
        System.out.println("Nhập tên đăng nhập cần đăng ký: ");
        String username= scanner.nextLine();

        System.out.println("Nhập mật khẩu: ");
        String password = scanner.nextLine();

        System.out.println("nhập sdt : ");
        int sdt= scanner.nextInt();
        scanner.nextLine();

        if (!UserService.isDuplicateUserName(username)){
            int id = UserService.createIdForNewAccount();
            Seller seller = new Seller(id,username,password,sdt);
            users.add(seller);
            MainMenu.updateData();

            System.out.println("Đăng ký thanhf công!");
        } else {
            System.out.println("Tên đăng nhập đã tồn tại!");
        }
    }

    public void login(User user) {
        do {
            MainMenu.updateData();
            System.out.println("Welcome " + user.getUsername()+"!\n"+
                    "1. Put Property up for sale\n" +
                    "2. Change password\n" +
                    "3. Display your properties\n"+
                    "0. Logout\n");
            int SellerLoginChoice= scanner.nextInt();
            scanner.nextLine();

            switch(SellerLoginChoice){
                case Constants.SELLER_SELL:
                    putPropertyUpforSale(user);
                    break;
                case Constants.USER_CHANGE_PASSWORD:
                    UserService.changePassword(user);
                    break;
                case Constants.DISPLAY_PROPERTY:
                    displayProperty(user);
                    break;
                case Constants.USER_LOGOUT:
                    return;
                default:
                    System.out.println("Vui lòng nhập đúng lựa chọn");
            }
        }while (true);
    }

    private void putPropertyUpforSale(User user){
        System.out.println("Loại bất đông sản bạn cần mua? \n" +
                "1. Đất Phố\n" +
                "2. Nhà Số\n");
        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case Constants.SELL_GROUND_PROPERTY:
                PropertyService.createGroundProperty(user);
                break;
            case Constants.SELL_APARTMENT_PROPERTY:
                PropertyService.createApartmentProperty(user);
                break;
            default:
                System.out.println("Vui lòng nhập đúng lựa chọn");
        }
    }
    private void displayProperty(User user){
        for (Property property: ((Seller) user).getProperties()){
            System.out.println(property);
        }
    }
}
