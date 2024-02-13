package models;

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
    private String courseName;
    private int teacher_id;

    public Courses(String courseName, int teacher_id)
    {
        setCourseName(courseName);
        setTeacher_id(teacher_id);
    }
    @Override
    public String toString() {
        return id + " " + teacher_id;
    }
}