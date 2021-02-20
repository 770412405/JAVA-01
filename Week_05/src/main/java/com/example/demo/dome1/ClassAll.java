package com.example.demo.dome1;

import com.example.demo.dome1.Student;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;
/**
 * @author: 肖震
 * @date: 2021/2/21
 * @since:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClassAll {
    private String name;

    private List<Student> students;

    public void info() {
        System.out.println("class " + name + " : ");
        students.forEach(Student::info);
    }
}
