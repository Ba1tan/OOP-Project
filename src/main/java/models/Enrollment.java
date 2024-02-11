package models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class Enrollment {
    private int id;
    private int student_id;
    private int course_id;


    @Override
    public String toString() {
        return id + " " + student_id + " " + course_id;
    }
}