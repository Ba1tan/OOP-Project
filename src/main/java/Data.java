import java.util.ArrayList;

public interface Data{
    ArrayList getAll();

     void setNew(String name, String surname, int age, String email);

    void updateInfo(String columnLabel, String value, int id);

}
