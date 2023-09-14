package service.impl;

import constants.Constants;
import entity.Admin;
import entity.Buyer;
import entity.Seller;
import entity.User;
import service.IUser;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class UserService implements IUser {
    public static List<User> users;
    private static final Scanner scanner;

    static {
        users = new ArrayList<>();
        scanner = new Scanner(System.in);
    }


    @Override
    public void register() {

        System.out.println("Bạn là? \n" +
                "1. Buyer\n" +
                "2. Seller\n");
        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case Constants.BUYER_CHOICE:
                BuyerService.createOneBuyer();
                break;
            case Constants.SELLER_CHOICE:
                SellerService.createOneSeller();
                break;
            default:
                System.out.println("Vui lòng nhập đúng lựa chọn");
        }

    }

    @Override
    public void login() {
        System.out.println("Nhập tên đăng nhập:");
        String username = scanner.nextLine();
        System.out.println("Nhập mật khẩu:");
        String password = scanner.nextLine();

        User user = findUserByUsernameAndPassword(username, password);
        if (user!=null){
            if(user instanceof Buyer){
                BuyerService.BuyerMenu();
            }
            if(user instanceof Seller){
                SellerService.SellerMenu();
            }
            if(user instanceof Admin){
                AdminService.adminMenu();
            }
        } else {
            System.out.println("Thông tin đăng nhập sai!");
            return;
        }
    }

    private User findUserByUsernameAndPassword(String username, String password) {
        for (User user : users) {
            if ((user.getUsername().equals(username)) &&
                    (user.getPassword().equals(password))) {
                return user;
            }
        }
        return null;
    }
    @Override
    public void logout(){

}
}