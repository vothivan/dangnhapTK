package controller;
import common.AppConst;
import model.MenuItem;
import model.Person;
import java.util.Scanner;
public class MenuItemController {
    PersonController personController = new PersonController();
    Scanner sc = new Scanner(System.in);
    public void showMenuHome(){
        System.out.println(AppConst.nameProject);
        MenuItem dangnhap = new MenuItem(1,"dang nhap");
        MenuItem dangky = new MenuItem(2,"dang ky");
        MenuItem thoat = new MenuItem(0, "thoat");
        showMenu(dangnhap, dangky, thoat);
        while(true){
            System.out.println("Moi ban nhap lua chon theo dung thu tu tren hinh");
            int chon = new Scanner(System.in).nextInt();
            actionMenuHome(chon);
            showMenuHome();
        }

    }
    public  void actionMenuHome(int option)
    {
        switch(option){
            case 1:
                Person p1 = personController.signIn();
                if(p1!=null)  showMenuDangNhap(p1);
                break;
            case 2:
                personController.signUp();
                break;
            case 3:
                personController.searchName();
            case 0:
                System.exit(0);
                break;
            default:
                System.out.println("ban chon sai, vui long chon lai");
                break;
        }
    }
    public void showMenuDangNhap(Person p){
        System.out.println("chao mung"+p.getName()+ "den voi he thong BKES");
        MenuItem timKiem = new MenuItem(1,"tim kiem");
        MenuItem khoaTK = new MenuItem(2,"khoa tai khoan");
        MenuItem xoaTK = new MenuItem(2,"xoa tai khoan");
        MenuItem thoat = new MenuItem(0, "thoat");
        if(p.isAdmin()){
            showMenu(timKiem, xoaTK, thoat);
        }
        else showMenu(timKiem, khoaTK, thoat);
        int chon = new Scanner(System.in).nextInt();
        while (true){
            actionMenuDangNhap(p, chon);
            showMenuDangNhap(p);
        }
    }
    public void actionMenuDangNhap(Person p, int option){
        if(p.isAdmin()){
            switch (option){
                case 1:

                    break;
                case 2:
                    //goi den xoa tai khoan
                    break;
                case 3:
                    System.exit(0);
                    break;
                default:
                    System.out.println("chuc nang chua ho tro, vui long thu lai");
            }
        }
        else {

            switch (option){
                case 1:

                    break;
                case 2:
                    // goi den khoa tai khoan
                    break;
                case 3:
                    System.exit(0);
                    break;
                default:
                    System.out.println("chuc nang chua ho tro, vui long thu lai");
            }
        }

    }

    public  void showMenu(MenuItem ...listMenu){
        int size = listMenu.length;
        for (int i=0; i<size; i++){
            System.out.println(listMenu[i]);
        }
    }




}
