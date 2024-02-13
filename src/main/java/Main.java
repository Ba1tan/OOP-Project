import models.*;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        DbManagment dbm = new DbManagment();
        StudentManage std = new StudentManage();
        TeacherManage tcd = new TeacherManage();
        ArrayList<Student> Students = new ArrayList<>();
        ArrayList<Teacher> Teachers = new ArrayList<>();
        while(true){
            System.out.println("1: Show all data" + '\n' + "2: insert new Student" + '\n' + "3: Insert new Teacher" + '\n' + "4: Creat course" + '\n' + "4: Exit");
            Scanner sc = new Scanner(System.in);
            try{
                int ans = sc.nextInt();
                if(ans == 1)
                {
                    System.out.println("Student table:");
                    Students = std.getAll();
                    for(Student st : Students)
                    {
                        System.out.println(st);
                    }
                    System.out.println('\n' + "Teacher table:");
                    Teachers = tcd.getAll();
                    for(Teacher tc : Teachers)
                    {
                        System.out.println(tc);
                    }
                }
                else if (ans == 2)
                {
                    try {
                        System.out.println("Enter name, surname, age, email");
                        std.setNew(sc.next(), sc.next(), sc.nextInt(), sc.next());
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
                        tcd.setNew(sc.next(), sc.next(), sc.nextInt(), sc.next());
                    }
                    catch(InputMismatchException e) {
                        System.out.println("try again! You entered wrong data");
                    }
                    catch(RuntimeException e) {
                        System.out.println("Try again! You entered negative number");
                    }
                }
                else if (ans == 4)
                {
                    try
                    {
                        System.out.println("Enter the course name and teacher id");
                        dbm.creatCourse(sc.next(), sc.nextInt());
                    }
                    catch (Exception e)
                    {
                        throw new RuntimeException(e);
                    }
                }
                else if (ans == 5)
                {
                    std.closeConnection();
                    tcd.closeConnection();
                    break;
                }
                else
                {
                    System.out.println("Enter a number between 1 and 5");
                }
            }
            catch(InputMismatchException e){
                System.out.println("ENTER A NUMBER!");
            }
        }

    }
}

