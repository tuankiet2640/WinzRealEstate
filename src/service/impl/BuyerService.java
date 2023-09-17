package service.impl;

import constants.Constants;
import entity.Buyer;
import entity.Property;
import entity.Seller;
import entity.User;
import service.IFind;

import java.io.Serializable;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class BuyerService implements Serializable {
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
            MainMenu.updateData();
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
                        "3. Pick a property \n" +
                        "0. Logout\n");
                int buyerLoginChoice= scanner.nextInt();
                scanner.nextLine();

                switch(buyerLoginChoice){
                    case Constants.BUYER_VIEW:
                        viewProperty();
                        break;
                    case Constants.USER_CHANGE_PASSWORD:
                        UserService.changePassword(user);
                        break;
                        case Constants.BUYER_PICK_PROPERTY:
                            buyProperty();
                            break;
                    case Constants.USER_LOGOUT:
                        return;
                    default:
                        System.out.println("Vui lòng nhập đúng lựa chọn");
                }
            }while (true);

    }
    private void viewProperty(){
        List<Property> propertyList= PropertyService.getPropertyList();
        System.out.println("Bạn muốn xem nhà theo gì: ");
        System.out.println("1. Theo giá từ cao tới thấp ");
        System.out.println("2. Theo giá từ thấp tới cao ");
        System.out.println("3. Theo alphabet ");

        int choice = scanner.nextInt();
        scanner.nextLine();

        IFind iFind= IFindFactory.createIFind(choice);
        iFind.find();
    }

    private void buyProperty() {
        System.out.println("Nhập Property Id cần mua: ");
        int propertyId= scanner.nextInt();
        scanner.nextLine();

        Property property = PropertyService.findPropertyById(propertyId);
        if (property!=null){
            System.out.println(property);
            System.out.println(PropertyService.propertySellerInfo(property).getUsername()+ ": "+((Seller)PropertyService.propertySellerInfo(property)).getPhoneNumber());
        }
    }

}
