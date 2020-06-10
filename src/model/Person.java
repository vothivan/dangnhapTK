package model;
import java.util.Date;
public class Person {
    private int id;
    private String name;
    private byte sex;//0 là nam, 1 là nữa, 2 là khác
    private String email;
    private String password;
    private String phoneNumber;
    private String address;
    private byte status;
    private boolean admin; //true là admin.

    public Person(int id, String name, byte sex, String email, String password, String phoneNumber, String address, byte status, boolean admin) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.email = email;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.status = status;
        this.admin = admin;
    }

    public byte getSex() {
        return sex;
    }

    public void setSex(byte sex) {
        this.sex = sex;
    }

    public byte getStatus() {
        return status;
    }

    public void setStatus(byte status) {
        this.status = status;
    }


    public String toString()
    {
        return "Person{"+ "id= "+id +", name=" + name + ", sex= "+ (sex==0 ? "Nam " : sex==1 ? "nu" : "khac")+
        "email= "+
                email+", password= "+password+", phoneNumber= "+phoneNumber+
                ", address= "+address+", status= "+status+", admin= "+admin+"}";
    }

    public Person(){
    }
    public Person(String name) {
        this.name = name;
        this.id=id;
    }

    public void printThis()
    {
        System.out.println(this);
    }

    public boolean isAdmin()
    {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }


    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

}
