package service.impl;

import constants.Constants;
import entity.*;
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
                            buyProperty(user);
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

    private void buyProperty(User user) {
        Buyer buyer = (Buyer)user;
        System.out.println("Nhập Property Id cần mua: ");
        int propertyId= scanner.nextInt();
        scanner.nextLine();

        System.out.println("thông tin BDS là");
        Property property = PropertyService.findPropertyById(propertyId);
        Seller seller =PropertyService.propertySellerInfo(property);
        if (property!=null){
            System.out.println(property);
                System.out.println(seller.getUsername()+ ": "+seller.getPhoneNumber());
        } else {
            System.out.println(" ko có bds với id trên");
        }

        System.out.println("bạn có muốn tạo hợp đồng nháp? ");
        System.out.println("1. có");
        System.out.println("2. ko");

        int chotDon=scanner.nextInt();
        scanner.nextLine();

        switch (chotDon){
            case Constants.YES:
                createDraftContract(buyer,seller,property);
                break;
            case Constants.NO:
                break;

        }

    }

    private void createDraftContract(Buyer buyer, Seller seller, Property property) {
        System.out.println("Hợp đồng nháp gồm bên A: "+ buyer.getUsername()+" và bên B: "+ seller.getUsername()+" về mua bán bds "+ property.getPropertyTitle() +" đã được gửi về email của seller la "+ buyer.getEmail());
        DraftContract draftContract= new DraftContract(property,buyer,seller);
        return;
    }


}
