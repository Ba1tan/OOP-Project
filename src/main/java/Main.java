import models.*;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        DbManagment dbm = new DbManagment();
        StudentManage std = new StudentManage();
        TeacherManage tcd = new TeacherManage();
        Scanner sc = new Scanner(System.in);
        while(true){
            System.out.println("1: Student manage" + '\n' + "2: Teacher manage" + '\n' + "3: Courses" + '\n' + "4: Enrollments(didnt implemented yet)" + '\n'  + "5: Exit");
            try{
                int ans = sc.nextInt();
                if(ans == 1)
                {
                    System.out.println("1.Show all Students" + '\n' + "2. Insert new Student" + '\n' + "3. Update info");
                    ans = sc.nextInt();
                    if(ans == 1)
                    {
                        System.out.println("Students table: ");
                        for(Student student : std.getAll())
                        {
                            System.out.println(student);
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
                        System.out.println("Enter the column label, value and id");
                        std.updateInfo(sc.next(), sc.next(), sc.nextInt());
                    }

                }
                else if (ans == 2)
                {
                    System.out.println("1.Show all Teachers" + '\n' + "2. Insert new Teacher" + '\n' + "3. Update info");
                    ans = sc.nextInt();
                    if(ans == 1)
                    {
                        System.out.println("Teacher table: ");
                        for(Teacher teacher : tcd.getAll())
                        {
                            System.out.println(teacher);
                        }
                    }
                    else if (ans == 2)
                    {
                        try {
                            System.out.println("Enter name, surname, age, email");
                            tcd.setNew(sc.next(), sc.next(), sc.nextInt(), sc.next());
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
                        System.out.println("Enter the column label, value and id");
                        tcd.updateInfo(sc.next(), sc.next(), sc.nextInt());
                    }
                }
                else if (ans == 3)
                {
                    System.out.println("1.Show all Courses" + '\n' + "2. Create new Course");
                    ans = sc.nextInt();
                    if(ans == 1)
                    {
                        System.out.println("Courses: ");
                        for(Courses courses : dbm.showCourses())
                        {
                            System.out.println(courses);
                        }
                    }
                    else if (ans == 2)
                    {
                        System.out.println("Enter the course name and teacher id");
                        dbm.creatCourse(sc.next(), sc.nextInt());
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

