package com.teen.review.Bean;

/**
 * @author teen
 * @create 2021/10/8 10:45
 */
public class Teacher implements Person {

    private int age;
    private String name;

    @Override
    public void sayHello() {
        System.out.println("同学您好，我是" + name +"老师");
    }

    @Override
    public int sayAge() {
        return age;
    }

    public Teacher() {
    }

    public Teacher(int age, String name) {
        this.age = age;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
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
