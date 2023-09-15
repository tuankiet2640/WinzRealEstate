package service.impl;

import constants.Constants;
import entity.Seller;
import entity.User;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class SellerService {
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
            System.out.println("Đăng ký thanhf công!");
        } else {
            System.out.println("Tên đăng nhập đã tồn tại!");
        }
    }

    public void login(User user) {
        do {
            System.out.println("Welcome " + user.getUsername()+"!\n"+
                    "1. Put Property up for sale\n" +
                    "2. Change password\n" +
                    "3. Logout\n");
            int SellerLoginChoice= scanner.nextInt();
            scanner.nextLine();

            switch(SellerLoginChoice){
                case Constants.SELLER_SELL:
                    putPropertyUpforSale(user);
                    break;
                case Constants.USER_CHANGE_PASSWORD:
                    UserService.changePassword(user);
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
                "2. Đất Số\n");
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
}
