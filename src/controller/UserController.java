package controller;

import java.util.Scanner;

public class UserController {
    Scanner tmp = new Scanner(System.in);
    public void check_phoneNumber()
    {
        System.out.println("moi ban nhap so dien thoai: ");
        String phonenumber = "";

        while (true) {
             phonenumber = tmp.nextLine();

            if (phonenumber.matches("\\d")) {
                break;
            }
            System.out.println("ban nhap sai email, moi nhap lai");
        }

    }


}
