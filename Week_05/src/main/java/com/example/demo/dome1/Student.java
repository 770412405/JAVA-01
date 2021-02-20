package com.example.demo.dome1;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
/**
 * @author: 肖震
 * @date: 2021/2/21
 * @since:
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Student {
    private int id;

    private String name;

    private String classNo;

    public void info() {
        System.out.println("student-->id:[" + id + "],name:[" + name + "],classNo:[" + classNo + "]");
    }
}
