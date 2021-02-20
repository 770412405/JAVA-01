package com.example.demo.dome1;
import com.example.demo.dome1.ClassAll;
import com.example.demo.dome1.Student;
import lombok.Data;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
/**
 * @author: 肖震
 * @date: 2021/2/21
 * @since:
 */
@Configuration
@Data
public class ClassAllConfig implements ApplicationContextAware{
    private ApplicationContext applicationContext;
    @Bean("class_all")
    public ClassAll build() {
        /**获取到bean
         * */
        List<Student> students = new ArrayList<>();
        Optional<Object> student = Optional.ofNullable(applicationContext.getBean("student3"));
        student.ifPresent(obj -> students.add((Student) obj));

        student = Optional.ofNullable(applicationContext.getBean("student4"));
        student.ifPresent(obj -> students.add((Student) obj));
        return new ClassAll("B", students);
    }
}
