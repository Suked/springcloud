package com.sut.cloud.service.impl;

import com.sut.cloud.domain.vo.User;
import com.sut.cloud.mapper.UserMapper;
import com.sut.cloud.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public Integer userAdd(User user) {
        user.setCreatedTime(new Date());
        return userMapper.insert(user);
    }

    @Override
    public User findById(Long id) {
        User user = userMapper.selectById(id);
        return user;
    }
}
