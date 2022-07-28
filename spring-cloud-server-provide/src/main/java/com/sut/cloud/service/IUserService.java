package com.sut.cloud.service;

import com.sut.cloud.domain.vo.User;

public interface IUserService {
    Integer userAdd(User user);

    User findById(Long id);
}
