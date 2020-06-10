package model;
import java.util.ArrayList;
public class JavaITStudent {
    private int id;
    private ArrayList<Student> listStudent;
    private Teacher teacher;

    public JavaITStudent()
    {
    }

    public JavaITStudent(int id, ArrayList<Student> listStudent) {
        this.id = id;
        this.listStudent = listStudent;
    }
}
