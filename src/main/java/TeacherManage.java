import models.Student;
import models.Teacher;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class TeacherManage extends DbManagment implements Data{

    private ArrayList<Teacher> Teachers;
    public TeacherManage()
    {
        super();
        Teachers = new ArrayList<>();
    }
    @Override
    public ArrayList<Teacher> getAll()
    {
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
        if(Teachers.size() == 0)
        {
            System.out.println("No data");
        }
        return Teachers;
    }
    @Override
    public void setNew(String name, String surname, int age, String email) {
        Teacher teacher = new Teacher(name, surname, age, email);
        String sql = "insert into public.\"Teacher\" (teacher_name, teacher_surname, teacher_age, teacher_email) values (?, ?, ?, ?)";
        try
        {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, teacher.getName());
            stmt.setString(2, teacher.getSurname());
            stmt.setInt(3, teacher.getAge());
            stmt.setString(4, teacher.getEmail());
            stmt.executeUpdate();
            System.out.println("Successfully");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
