package com.teen.review.Bean;

/**
 * @author teen
 * @create 2021/10/8 10:49
 */
public class Student implements Person{
    private int age;
    private String name;

    @Override
    public void sayHello() {
        System.out.println("hi，我叫" + name);
    }

    @Override
    public int sayAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }

    public Student() {
    }


    public Student(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
