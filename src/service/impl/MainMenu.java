package service.impl;

import constants.Constants;
import entity.Admin;
import entity.Property;
import entity.User;

import java.io.*;
import java.util.List;
import java.util.Scanner;

public class MainMenu {
    private static final Scanner scanner = new Scanner(System.in);

    public static void mainMenu() {
        UserService userService = new UserService();
        loadData();
        updateData();
        PropertyService.updatePropertyList();
        UserService.displayUserList();
        PropertyService.displayPropertyList();
        do {
                System.out.println("\n" +
                        "1. Register\n" +
                        "2. Login\n" +
                        "3. Exit\n");
                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case Constants.REGISTER_CHOICE:
                        userService.register();
                        break;
                    case Constants.LOGIN_CHOICE:
                        userService.login();
                        break;
                    case Constants.EXIT_CHOICE:
                        scanner.close();
                        System.exit(0);
                    default:
                        System.out.println("Vui lòng nhập đúng lựa chọn");
                }
            } while (true);


    }
    public static void loadData(){
        File userdata= UserService.getUserdata();
        if (userdata.length()!=0){
            try {
                ObjectInputStream ois= new ObjectInputStream(new FileInputStream(userdata));
                UserService.setUsers((List<User>)ois.readObject());
                ois.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
    }
    public static void updateData() {
        List<User> users= UserService.getUsers();
//        Admin admin= Admin.getAdmin();
//users.add(admin);
        try {
            ObjectOutputStream oos= new ObjectOutputStream(new FileOutputStream(UserService.getUserdata()));
            oos.writeObject(users);
            oos.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}