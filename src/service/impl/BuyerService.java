package service.impl;

import constants.Constants;
import entity.Buyer;
import entity.User;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class BuyerService {
    private static final Scanner scanner;
    private static List<User> users;

    static {
        scanner= new Scanner(System.in);
        users=  UserService.getUsers();
    }
    public void register() {
        System.out.println("Nhập tên đăng nhập cần đăng ký: ");
        String username= scanner.nextLine();

        System.out.println("Nhập mật khẩu: ");
        String password = scanner.nextLine();

        System.out.println("nhập email: ");
        String email= scanner.nextLine();

        if (!UserService.isDuplicateUserName(username)){
            int id = UserService.createIdForNewAccount();
            Buyer buyer = new Buyer(id,username,password,email);
            users.add(buyer);
            System.out.println("Đăng ký thanhf công!");
        } else {
            System.out.println("Tên đăng nhập đã tồn tại!");
        }
    }

    public void login(User user) {
        do {
                System.out.println("Welcome " + user.getUsername()+"!\n"+
                        "1. View Available Properties\n" +
                        "2. Change password\n" +
                        "3. Logout\n");
                int buyerLoginChoice= scanner.nextInt();
                scanner.nextLine();

                switch(buyerLoginChoice){
                    case Constants.BUYER_VIEW:
                        viewProperty(user);
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
    private void viewProperty(User user){

    }
    public void logout() {

    }
}
