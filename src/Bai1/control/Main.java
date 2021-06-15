package Bai1.control;


import Bai1.model.User;
import Bai1.model.Validate;
import Bai1.service.ManageUser;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        ManageUser manageUser = new ManageUser();
        int choice;
        Scanner sc = new Scanner(System.in);
        while (true){
            displayMenu();
            System.out.println("Nhap lua chon vao day");
            choice = sc.nextInt();
            sc.nextLine();
            switch (choice){
                case 1:
                    manageUser.display();
                    break;
                case 2:
                    manageUser.add(createUser());
                    break;
                case 3:
                    System.out.println("Nhap so dien thoai can sua");
                    String number = sc.nextLine();
                    int index = manageUser.checkIndex(number);
                    if( index !=-1){
                        User user = createUser();
                        manageUser.edit(index,user);
                    }else {
                        System.out.println("Invalid number");
                    }
                    break;
                case 4:
                    System.out.println("Nhap so dien thoai can sua");
                    number = sc.nextLine();
                    index = manageUser.checkIndex(number);
                    if(index!=-1){
                        System.out.println("Nhap Y de xoa");
                        String apply = sc.nextLine();
                        if(apply.equals("Y")){
                            manageUser.delete(index);
                        }else {
                            break;
                        }
                    }else {
                        System.out.println("Invalid");
                    }
                    break;
                case 5:
                    System.out.println("1. search by number   2. search by name");
                    int option = sc.nextInt();
                    sc.nextLine();
                    if(option==1){
                        System.out.println("Nhap so dien thoai can tim");
                        number = sc.nextLine();
                        index = manageUser.checkIndex(number);
                        if(index!=-1){
                            System.out.println( manageUser.searchByNumber(number));
                        }else {
                            System.out.println("Invalid number");
                        }
                    }else if(option==2){
                        System.out.println("Nhap ten can tim");
                        String name = sc.nextLine();
                        if( manageUser.search(name).size()==0){
                            System.out.println(" invalid user");
                        }else {
                            for (User user: manageUser.search(name)){
                                System.out.println(user);
                            }
                        }
                    }else {
                        System.out.println(" Invalid choice");
                    }
                    break;
                case 6:
                    System.out.println(" Ban co muon cap nhat lai bo nho ?  1.Yes  2.No" );
                    choice = sc.nextInt();
                    sc.nextLine();
                    if(choice==1){
                        try {
                            for (User user: manageUser.readFileCSV("data.csv")){
                                System.out.println(user);
                            }
                        }catch (Exception e){
                            e.printStackTrace();
                        }
                    }else if(choice==2) {
                        System.out.println("Cancelled");
                    }else {
                        System.out.println("Invalid choice");
                    }

                    break;
                case 7:
                    System.out.println("ban co chac chan muon cap nhat danh ba?  1. Yes  2. No");
                    choice = sc.nextInt();
                    sc.nextLine();
                    if(choice==1){
                        manageUser.writeToFileCSV("data.csv",manageUser.getUserList());
                    }else {
                        System.out.println("Canceler");
                    }
                    break;
                case 8:
                    System.exit(0);
            }
        }

    }
    public static User createUser(){
        Validate validate = new Validate();
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap nhom");
        String group = sc.nextLine();
        System.out.println("Nhap ten");
        String name = sc.nextLine();
        System.out.println("chon gioi tinh 1. Nam   2. Nu ");
        int choice = sc.nextInt();
        sc.nextLine();
        boolean gender;
        if(choice==1){
            gender = true;
        }else {
            gender = false;
        }
        System.out.println("Nhap ngay sinh");
        String dob = sc.nextLine();
        System.out.println("Nhap so dien thoai");
        String number = sc.nextLine();
        if(validate.validateRegex(number,Validate.NUMBER_REGEX)){
            System.out.println("Nhap dia chi");
            String address = sc.nextLine();
            System.out.println("Nhap email");
            String email = sc.nextLine();
            if(validate.validateRegex(email,Validate.EMAIL_REGEX)){
                return new User(group, name,gender, dob,number,address,email);
            }
        }
        return createUser();

    }
    public static void displayMenu(){
        System.out.println("Chuong trinh quan ly danh ba");
        System.out.println("1. Xem danh sach");
        System.out.println("2.Them moi");
        System.out.println("3.Cap nhat");
        System.out.println("4.Xoa");
        System.out.println("5.Tim kiem");
        System.out.println("6.Doc tu file");
        System.out.println("7.Ghi vao file");
        System.out.println("8.Thoat");
    }
}
