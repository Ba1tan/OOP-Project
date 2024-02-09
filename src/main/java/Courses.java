import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Courses {
    private int id;
    private int teacher_id;



    @Override
    public String toString() {
        return id + " " + teacher_id;
    }
}