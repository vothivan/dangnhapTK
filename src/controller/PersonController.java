package controller;
import model.Person;
import common.AppConst;
import java.util.Scanner;
import service.PersonService;
import serviceimpl.PersonServiceImpl;
import java.util.ArrayList;
//dang nhap, dang ky voi truong status, tim kiem cac thuoc tinh
public class PersonController {
   PersonServiceImpl personService = new PersonServiceImpl();
    Scanner sc = new Scanner(System.in);
    //sign in

    public Person signIn(){
        return personService.signIn();
    }
    //sign up
    public Person signUp() {
        System.out.println("***dang ki***");
        Person p = null;
        p = new Person(AppConst.count++, checkName(), checkSex(), checkEmail(),
                checkPassword(), checkPhoneNumber(), checkAddress(), (byte) 0, false);
        AppConst.listPerson.add(p);
        System.out.println("***dang ki thanh cong, moi ban dang nhap he thong***");
        return p;

    }

    public String checkName() {
        String name = "";
        while (true) {
             printInput("ten: ");
            name = sc.nextLine();
            if(name.matches("^[A-Z]\\w+")) {
                break;
            }
            printError("ten");
        }
        return name;
    }

    //. Mật khẩu tối thiểu 1 ký tự, 1 chữ cái và 1 ký tự đặc biệt và lớn hơn hoặc bằng 8 ký tự
    public String checkPassword() {
        String password = "";
        while (true) {
            printInput("mật khẩu");
            password = sc.nextLine();
            if(isPassword(password)) {
                break;
            }
            printError("mật khẩu");
        }
        return password;
    }

    public byte checkSex(){
        byte sex = 0;
        while (true) {
            printInput("giới tính: 0-Nữ,1-Name,2-Khác");
            sex = new Scanner(System.in).nextByte();
            if(sex >=0 && sex <= 2){
                break;
            }
            printError("giới tính: 0-Nữ,1-Name,2-Khác");
        }
        return sex;
    }
    public String checkPhoneNumber() {
        String phone="";
        while (true){
            printInput("moi ban nhap sdt: ");
            phone=sc.nextLine();
            if(phone.matches("09|03|08)\\d{8}")){
                printError("sdt");
                break;
            }
        }
        return phone;
    }
    public String checkEmail() {
        String rs = "";
        while(true) {
            printInput("email");
            rs = sc.nextLine();
            if(isEmail(rs)) {
                if(!checkInitEmail(rs)) {
                    break;
                }
                System.out.println("Email đã tồn tại. Vui lòng nhập lại.");
            }
            else printError("email");
        }
        //to do
        return rs;
    }
    public boolean checkInitEmail(String email) {
        boolean rs = false;
        for (Person p : AppConst.listPerson) {
            if(p.getStatus() < 2 && p.getEmail().equals(email)) rs = true;
        }
        return rs;
    }

    public String checkAddress(){
        String rs="";
        while(true){
            printInput("dia chi");
            rs=sc.nextLine();
            if(rs.matches("^[A-Z]\\w+ (([A-Z]\\w+)||(([A-Z]\\w+ [A-Z]\\w+)))")){
                break;
            }
        }
        return rs;
    }

    public boolean isEmail(String email){
        return true;
    }
    public boolean isPassword( String password) {
        return password.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])[a-zA-Z0-9]{8,}$"); }
    public void printInput(String text) {
        System.out.println("Mời bạn nhâp "+ text+" : "); }
    public void printError(String text) {
        System.out.println("Nhập lỗi định dạng của "+ text + ". Vui lòng nhập lại"); }

    public void searchAddress(boolean admin) {

        printInput("tim kiem theo dia chi");
        int count = 0;
        String address = new Scanner(System.in).nextLine();
        for (Person p : AppConst.listPerson) {

            if ((p.getStatus() == 0 || (admin && p.getStatus() == 1)) && p.getAddress().toUpperCase().indexOf(address.toUpperCase()) > -1) {
                count++;
                System.out.println(p);
            }
        }
        if (count ==0 ) System.out.println("khong co noi dung tim kiem phu hop");
        else System.out.println("co "+count +" thong tin tim kiem phu hop");

    }
    public void searchName(){
        boolean admin;
        admin=sc.nextBoolean();
        printInput("tim kiem theo ten");
        String name = new Scanner(System.in).nextLine();
        int count=0;
        for (Person p : AppConst.listPerson) {

            if ((p.getStatus() == 0 || (admin && p.getStatus() == 1)) && p.getName().toUpperCase().indexOf(name.toUpperCase()) > -1) {
                count++;
                System.out.println(p);
            }
        }
            if (count==0){
                System.out.println("khong co truong thong tin phu hop");
            }
            else System.out.println("co"+count+"nguoi dung phu hop");
        }
        public void searchSex(boolean admin){
        printInput("tim kiem theo gioi tinh");
        Byte sex = new Scanner(System.in).nextByte();
        int countNam = 0;
        int countNu=0;
        int countKhac=0;
        for (Person p : AppConst.listPerson){
            if ((p.getStatus() == 0 || (admin && p.getStatus() == 1))) {
                int option=0;
                switch(option){
                    case 1:
                        countNam++;
                        break;
                    case 2:
                        countNu++;
                        break;
                    case 0:
                        countKhac++;
                        break;
                    default:
                        System.out.println("nhap sai gioi tinh");
            }
        }
        }
        if (countKhac==0 && countNam==0 && countNu==0){
            System.out.println("khong co thong tin tim kiem phu hop");
        }
        }

    public void search(boolean admin){
        int count =0;
        System.out.println("***tim kiem chung***");
        printInput("ten");
        String name= new Scanner(System.in).nextLine();
        printInput("gioi tinh");
        Byte sex = new Scanner((System.in)).nextByte();
        printInput("dia chi");
        String address= new Scanner(System.in).nextLine();
        printInput("so dien thoai");
        String phoneNumber= new Scanner(System.in).nextLine();
        printInput("email");
        String email= new Scanner(System.in).nextLine();
        for (Person p : AppConst.listPerson){
            if((p.getStatus()==0|| (p.getStatus()==1 && admin))
                    && p.getName().toUpperCase().contains(name.toUpperCase())
                    && p.getAddress().toUpperCase().contains(address.toUpperCase())
                    && p.getPhoneNumber().toUpperCase().contains(phoneNumber.toUpperCase())
                    && p.getEmail().toUpperCase().contains(email.toUpperCase())
                    && (sex==-1 || p.getSex()==sex)){
                count++;
                System.out.println(p);

            }
        }
    }
    //tim kiem
//    public void findByName(boolean admin){
//        printInput("tim kiem theo ten");
//        String name = new Scanner(System.in).nextLine();
//        int count=0;
//        for (Person p : AppConst.listPerson) {
//
//            if ((p.getStatus() == 0 || (admin && p.getStatus() == 1)) && p.getName().toUpperCase().indexOf(name.toUpperCase()) > -1) {
//                count++;
//                System.out.println(p);
//            }
//        }
//            if (count==0){
//                System.out.println("khong co truong thong tin phu hop");
//            }
//            else System.out.println("co"+count+"nguoi dung phu hop");
//        }
//
//
//        public void findAddress(boolean admin){
//
//            printInput("tim kiem theo dia chi");
//            int count =0;
//            String address = new Scanner(System.in).nextLine();
//            for (Person p : AppConst.listPerson){
//
//                if ((p.getStatus()==0 || (admin && p.getStatus()==1)) && p.getAddress().toUpperCase().indexOf(address.toUpperCase()) > -1)
//                {
//                    count++;
//                    System.out.println(p);
//                }
//        }
//            if (count==0){
//                System.out.println("khong co truong thong tin phu hop");
//            }
//            else System.out.println("co"+count+"nguoi dung phu hop");
//    }
//    public void findId(boolean admin)
//    {
//        printInput("tim kiem theo ma id");
//        int count = 0;
//        int id = new Scanner(System.in).nextInt();
//        for (Person p : AppConst.listPerson){
//            if ((p.getStatus()==0) || (admin && p.getStatus()==1))
//            {
//                count++;
//                System.out.println(p);
//            }
//        }
//        if(count ==0) System.out.println("khong co thong tin phu hop");
//        else System.out.println("co"+count+"nguoi phu hop");
//    }
//
//    public void findPhoneNumber(boolean admin){
//        printInput("tim kiem theo so dien thoai ");
//        int count = 0;
//        String phoneNumber = new Scanner(System.in).nextLine();
//        for (Person p : AppConst.listPerson){
//            if ((p.getStatus()==0) || (admin && p.getStatus()==1)){
//                count++;
//                System.out.println(p);
//            }
//        }
//        if (count==0) System.out.println("khong co thong tin phu hop");
//        else System.out.println("co"+count+"nguoi phu hop");
//    }



}
