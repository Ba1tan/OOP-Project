import models.Student;
import models.Teacher;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        DbManagment dbm = new DbManagment();
        ArrayList<Student> Students = new ArrayList<>();
        ArrayList<Teacher> Teachers = new ArrayList<>();
        System.out.println("1: Show all data" + '\n' + "2: insert new Student" + '\n' + "3: Insert new Teacher");
        Scanner sc = new Scanner(System.in);
        int ans = sc.nextInt();
        if(ans == 1)
        {
            System.out.println("Student table:");
            Students = dbm.getAllStudents();
            for(Student st : Students)
            {
                System.out.println(st);
            }
            System.out.println("Teacher table:");
            Teachers = dbm.getAllTeachers();
            for(Teacher tc : Teachers)
            {
                System.out.println(tc);
            }
        }
        else if (ans == 2)
        {
            System.out.println("Enter name, surname, age, email");
            dbm.setNewStudent(new Student(sc.next(), sc.next(), sc.nextInt(), sc.next()));
        }
        else if (ans == 3)
        {
            System.out.println("Enter name, surname, age, email");
            dbm.setNewTeacher(new Teacher(sc.next(), sc.next(), sc.nextInt(), sc.next()));
        }
        dbm.closeConnection();
    }
}

