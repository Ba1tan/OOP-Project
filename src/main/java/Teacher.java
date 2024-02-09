import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Teacher {
    private int id;
    private String surname;
    private String name;
    private int age;
    private int email;


    @Override
    public String toString() {
        return id + " " +  name + " " + surname + " " + age + " " + email;
    }
}