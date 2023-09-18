package service.impl;

import constants.Constants;
import entity.User;

import java.io.Serializable;
import java.util.List;
import java.util.Scanner;

public class AdminService implements Serializable {
    public static Scanner scanner = new Scanner(System.in);
  public static void login(User user){
      do {
          System.out.println("Welcome " + user.getUsername()+"!\n"+
                  "1. View user list\n" +
                  "2. delete user\n" +
                  "0. Logout\n");
          int buyerLoginChoice= scanner.nextInt();
          scanner.nextLine();

          switch(buyerLoginChoice){
              case Constants.ADMIN_VIEW_USER_LIST:
                  viewUserList();
                  break;
              case Constants.ADMIN_DELETE_USER:
                  deleteUser();
                  break;
              case Constants.USER_LOGOUT:
                  return;
              default:
                  System.out.println("Vui lòng nhập đúng lựa chọn");
          }
      }while (true);
  }
  private static void viewUserList(){
      List<User> users= UserService.getUsers();
      for (User user:users){
          System.out.println(user);
      }
  }
  private static void deleteUser(){
      List<User> users= UserService.getUsers();
      System.out.println("nhập id user cần xoá");
      int userId= scanner.nextInt();
      scanner.nextLine();

      User user=  UserService.findUserById(userId);
      users.remove(user);
  }
}
