import java.sql.*;
public class Main
{
    public static void main(String[] args)
    {
        Connection con = DbConnection.getConnection();
        Statement stmt = null;
        ResultSet rslt = null;
        try {
            stmt = con.createStatement();
            stmt.executeUpdate("insert into public.\"Enrollment\" (student_id, course_id) values (1, 1)");
            rslt = stmt.executeQuery("select * from public.\"Courses\" join public.\"Teacher\" on \"Teacher\".teacher_id = \"Courses\".teacher_id;");
            while(rslt.next())
            {
                System.out.print(rslt.getString("course_name") + ": ");
                System.out.print(rslt.getString("teacher_name") + " ");
                System.out.println(rslt.getString("teacher_surname"));

            }
        }
        catch (SQLException e)
        {
            System.out.println("connection error: " + e.getMessage());
        }
        finally {
            if (con != null) {
                try {
                    con.close();
                }
                catch (SQLException e)
                {
                    System.out.println("could not close the connection: " + e.getMessage());
                }
            }
        }
    }
}

