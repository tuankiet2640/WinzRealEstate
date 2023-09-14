package service.impl;

import constants.Constants;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Controller {
    private static final Scanner scanner= new Scanner(System.in);
    public static void mainMenu(){
        UserService userService= new UserService();
        do {
            try {
                System.out.println("Welcome!\n" +
                "1. Register\n" +
                "2. Login\n" +
                "3. Exit\n");
        int choice= scanner.nextInt();
        scanner.nextLine();

        switch(choice){
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
            }catch (InputMismatchException e){
                System.out.println("Vui lòng nhập số");
                break;
            }
        } while (true);
    }

}

