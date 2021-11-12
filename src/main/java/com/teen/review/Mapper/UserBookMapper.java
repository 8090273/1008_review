package com.teen.review.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.teen.review.Bean.tBook;
import org.apache.ibatis.annotations.Mapper;

import javax.annotation.ManagedBean;
import java.util.List;
import java.util.Map;

/**
 * @author teen
 * @create 2021/10/20 9:34
 */
@Mapper
public interface UserBookMapper extends BaseMapper<tBook>{
    //这种设计很低级，因为没有将记录封装为对象
    public List<Map> SelectBookByUser(String username);

    public List<tBook> SelectBookPage(int firstPage,int num);
}
