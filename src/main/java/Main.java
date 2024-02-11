import models.Student;
import models.Teacher;

import java.util.ArrayList;

public class Main
{
    public static void main(String[] args)
    {
        DbManagment dbm = new DbManagment();
        ArrayList<Student> Students = dbm.getAllStudents();
        ArrayList<Teacher> Teachers = dbm.getAllTeachers();
        for(Student st : Students)
        {
            System.out.println(st);
        }
        for(Teacher tc : Teachers)
        {
            System.out.println(tc.toString());
        }
        dbm.setNewStudent(new Student("Gaziza", "Kruz", 19, "123654@mail.ru"));
    }
}

