import java.sql.*;
public class DbConnection
{
    private static String URL = "jdbc:postgresql://localhost:5432/postgres";
    private static String USERNAME = "postgres";
    private static String PASSWORD = "348576";


    public static Connection getConnection()
    {
        try
        {
            Class.forName("org.postgresql.Driver");
            return DriverManager.getConnection(URL, USERNAME, PASSWORD);
        }
        catch (SQLException e)
        {
            System.out.println("connection error: " + e.getMessage());
        }
        catch (ClassNotFoundException e)
        {
            System.out.println("Class not found" + e.getMessage());
        }
        return null;
    }
}
