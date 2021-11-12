package com.teen.review.Bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.util.List;

import static com.baomidou.mybatisplus.annotation.IdType.AUTO;

/**
 * 创建对应数据库中t_user表的对象
 * @author teen
 * @create 2021/10/17 11:06
 */
//指定表名,若不指定则默认类名为标明  注：_a == A 下划线后字母为大写
@TableName("t_user")
public class tUser {

    //以下所有属性必须在数据库中有对应字段
    //id为主键，且自动增长
    @TableId(type = AUTO)
    private int id;

    private String username;
    private String password;
    private String email;

    //字段不存在必须使用注解
    @TableField(exist = false)      //表示此字段在数据库中不存在
    private String headerImgPath;
    @TableField(exist = false)
    private List<tBook>  books;

    public tUser() {
    }

    public tUser(int id, String username, String password, String email) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
    }

    @Override
    public String toString() {
        return "tUser{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", headerImgPath='" + headerImgPath + '\'' +
                ", books=" + books +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getHeaderImgPath() {
        return headerImgPath;
    }

    public void setHeaderImgPath(String headerImgPath) {
        this.headerImgPath = headerImgPath;
    }

    public List<tBook> getBooks() {
        return books;
    }

    public void setBooks(List<tBook> books) {
        this.books = books;
    }
}
