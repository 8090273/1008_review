package com.teen.review.service.serviceImpl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.teen.review.Bean.tUser;
import com.teen.review.Mapper.UserMapper;
import com.teen.review.service.UserService;
import org.springframework.stereotype.Service;

/**
 * @author teen
 * @create 2021/10/17 11:23*/


//@Configuration  竟然也行！！！ 但最好还是只用在配置类上
//@Bean 不行，只能标在方法上
//@Component 也可以，但不规范,应该用在Bean上，这是service层，就用@Service
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, tUser> implements UserService {
}
