package com.teen.review.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.teen.review.Bean.tUser;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author teen
 * @create 2021/10/17 11:11
 */
//不要导错类
@Mapper
public interface UserMapper extends BaseMapper<tUser>{

    public tUser getUserById(Integer id);

    //实现一对多 查出一个用户的所有书，返回类型为用户
    public tUser getUserBookById(Integer id);
}
