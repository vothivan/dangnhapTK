package view;
import common.AppConst;
import controller.MenuItemController;
import controller.PersonController;
import model.Person;
public class Main {
    public static void main(String[] args) {
        MenuItemController menuItemController = new MenuItemController();
//        AppConst.listPerson.add(new Person(AppConst.count++,
//                "admin", (byte) 0, "admin@gmail.com",
//                "Ntduong106", "0966186222",
//                "Nghệ An", (byte) 0 , false));
//        AppConst.listPerson.add(new Person(AppConst.count++,"admin", (byte) 0, "admin@gmail.com",
//                "vanmeo49", "0947897762",
//                "Ha Tinh", (byte) 0 , false));
//       PersonController personController = new PersonController();
//        Person p = personController.signUp();
//        System.out.println(personController.signIn());
       menuItemController.showMenuHome();
    }

}
