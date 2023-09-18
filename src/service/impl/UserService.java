package service.impl;

import constants.Constants;
import entity.Admin;
import entity.Buyer;
import entity.Seller;
import entity.User;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserService implements Serializable{
    private static List<User> users;
    private static final Scanner scanner;
    private static int userId;
    private static final File USER_FILE= new File("src/files/userdata.txt");

    static {
        users = new ArrayList<>();
        scanner = new Scanner(System.in);
        userId=3000;
    }

    public static void displayUserList(){
        for (User user: users){
            System.out.println(user.getUsername());
        }
    }

    public void register() {
        System.out.println("Bạn là? \n" +
                "1. Buyer\n" +
                "2. Seller\n");
        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case Constants.BUYER_REGISTER_CHOICE:
                BuyerService buyerService= new BuyerService();
                buyerService.register();
                break;
            case Constants.SELLER_REGISTER_CHOICE:
                SellerService sellerService= new SellerService();
                sellerService.register();
                break;
            default:
                System.out.println("Vui lòng nhập đúng lựa chọn");
        }
    }

    public void login() {
        System.out.println("Nhập tên đăng nhập:");
        String username = scanner.nextLine();
        System.out.println("Nhập mật khẩu:");
        String password = scanner.nextLine();

        User user = findUserByUsernameAndPassword(username, password);
        if (user!=null){
            if(user instanceof Buyer){
                BuyerService buyerService= new BuyerService();
                buyerService.login(user);
            }
            if(user instanceof Seller){
                SellerService sellerService= new SellerService();
                sellerService.login(user);
            }
            if(user instanceof Admin){
                AdminService adminService= new AdminService();
                adminService.login(user);
            }
        } else {
            System.out.println("Thông tin đăng nhập sai!");
            return;
        }
    }
    public static void changePassword(User user) {
        System.out.println("Nhap mat khau moi: ");
        String newPassword= scanner.nextLine();

        user.setPassword(newPassword);
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
    public static User findUserById(int userId){
        for (User user : users) {
            if ((user.getUserId()==(userId))){
                return user;
            }
        }
        return null;
    }
    public static List<User> getUsers() {
        return users;
    }

    public static void setUsers(List<User> users) {
        UserService.users = users;
    }

    public static int createIdForNewAccount() {
        userId++;
        return userId;
    }
    public static boolean isDuplicateUserName(String username) {
        for (User user : users) {
            if ((user.getUsername().equals(username))) {
                return true;
            }
        }
        return false;
    }

    public static File getUserdata(){
        return USER_FILE;
    }
}