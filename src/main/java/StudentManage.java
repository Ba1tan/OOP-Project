import models.Student;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class StudentManage extends DbManagment implements Data{
    private final ArrayList<Student> Students;
    public StudentManage()
    {
        super();
        Students = new ArrayList<>();
    }

    @Override
    public ArrayList<Student> getAll()
    {
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

        }
        catch (SQLException e)
        {
            throw new RuntimeException(e);
        }
        if(Students.size() == 0)
        {
            System.out.println("No data");
        }
        return Students;
    }
    @Override
    public void setNew(String name, String surname, int age, String email)
    {
        Student student = new Student(name, surname, age, email);
        String sql = "insert into public.\"Student\" (student_name, student_surname, student_age, student_email) values (?, ?, ?, ?)";
        try
        {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, student.getName());
            stmt.setString(2, student.getSurname());
            stmt.setInt(3, student.getAge());
            stmt.setString(4, student.getEmail());
            stmt.executeUpdate();
            System.out.println("Successfully");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
