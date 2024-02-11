import models.Student;
import models.Teacher;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DbManagment
{
    private Connection con;
    public DbManagment()
    {
        con = DbConnection.getConnection();
    }
    public ArrayList<Student> getAllStudents()
    {
        ArrayList<Student> Students = new ArrayList<>();
        String sql = "select * from public.\"Student\"";
        try
        {
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rslt = stmt.executeQuery();
            while (rslt.next())
            {
                Student student = new Student();
                student.setId(rslt.getInt("student_id"));
                student.setName(rslt.getString("student_name"));
                student.setSurname(rslt.getString("student_surname"));
                student.setAge(rslt.getInt("student_age"));
                student.setEmail(rslt.getString("student_email"));
                Students.add(student);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return Students;
    }
    public ArrayList<Teacher> getAllTeachers()
    {
        ArrayList<Teacher> Teachers = new ArrayList<>();
        String sql = "select * from public.\"Teacher\"";
        try
        {
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rslt = stmt.executeQuery();
            while (rslt.next())
            {
                Teacher teacher = new Teacher();
                teacher.setId(rslt.getInt("teacher_id"));
                teacher.setName(rslt.getString("teacher_name"));
                teacher.setSurname(rslt.getString("teacher_surname"));
                teacher.setAge(rslt.getInt("teacher_age"));
                teacher.setEmail(rslt.getString("teacher_email"));
                Teachers.add(teacher);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return Teachers;
    }
    public void setNewStudent(Student student)
    {
        String sql = "insert into public.\"Student\" (student_name, student_surname, student_age, student_email) values (?, ?, ?, ?)";
        try
        {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, student.getName());
            stmt.setString(2, student.getSurname());
            stmt.setInt(3, student.getAge());
            stmt.setString(4, student.getEmail());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
