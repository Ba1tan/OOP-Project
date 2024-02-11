import models.Student;
import models.Teacher;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        while(true){
            DbManagment dbm = new DbManagment();
            ArrayList<Student> Students = new ArrayList<>();
            ArrayList<Teacher> Teachers = new ArrayList<>();
            System.out.println("1: Show all data" + '\n' + "2: insert new Student" + '\n' + "3: Insert new Teacher");
            Scanner sc = new Scanner(System.in);
            try{
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
                    try {
                        System.out.println("Enter name, surname, age, email");
                        dbm.setNewStudent(new Student(sc.next(), sc.next(), sc.nextInt(), sc.next()));
                    }
                    catch(InputMismatchException e) {
                        System.out.println("Try again! You entered wrong data");
                    }
                    catch(RuntimeException e) {
                        System.out.println("Try again! You entered negative number");
                    }
                }
                else if (ans == 3)
                {
                    try {
                        System.out.println("Enter name, surname, age, email(separated by namespace)");
                        dbm.setNewTeacher(new Teacher(sc.next(), sc.next(), sc.nextInt(), sc.next()));
                    }
                    catch(InputMismatchException e) {
                        System.out.println("try again! You entered wrong data");
                    }
                    catch(RuntimeException e) {
                        System.out.println("Try again! You entered negative number");
                    }
                }
                else{
                    System.out.println("Enter a number between 1 and 3");
                }
            }
            catch(InputMismatchException e){
                System.out.println("ENTER A NUMBER!");
            }
            dbm.closeConnection();
        }

    }
}

