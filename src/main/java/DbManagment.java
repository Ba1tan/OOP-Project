import models.Courses;
import models.Student;
import models.Teacher;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DbManagment {
    protected Connection con;

    public DbManagment() {
        con = DbConnection.getConnection();
    }

    public void creatCourse(String course_name, int id) {
        Courses courses = new Courses(course_name, id);
        String sql = "insert into public.\"Courses\" (course_name, teacher_id) values (?, ?)";
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, courses.getCourseName());
            stmt.setInt(2, courses.getTeacher_id());
            stmt.executeUpdate();
            System.out.println("Successfully");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public ArrayList<Courses> showCourses()
    {
        ArrayList<Courses> courses = new ArrayList<>();
        String sql = "select * from public.\"Courses\" join public.\"Teacher\" on \"Teacher\".teacher_id = \"Courses\".teacher_id";
        try
        {
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rslt = stmt.executeQuery();
            while (rslt.next())
            {
                Courses course = new Courses();
                course.setId(rslt.getInt(1));
                course.setCourseName(rslt.getString(2));
                course.setTeacher_name(rslt.getString(4));
                course.setTeacher_surname(rslt.getString(5));
                course.setTeacher_age(rslt.getInt(7));
                course.setTeacher_email(rslt.getString(6));
                course.setTeacher_id(rslt.getInt(8));
                courses.add(course);
            }

        }
        catch (SQLException e)
        {
            throw new RuntimeException(e);
        }
        return courses;
    }

    public void closeConnection() {
        try {
            con.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
