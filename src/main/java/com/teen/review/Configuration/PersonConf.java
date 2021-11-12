package com.teen.review.Configuration;

import com.teen.review.Bean.Person;
import com.teen.review.Bean.Student;
import com.teen.review.Bean.Teacher;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author teen
 * @create 2021/10/8 10:54
 */
@Configuration
public class PersonConf {

    @Bean("Quanlu")
    public Teacher Quanlu()
    {
        return new Teacher(73,"郑全录");
    }

    @Bean
    public Person ShiChuanHai()
    {
        return new Student(20,"史传海");
    }
}
