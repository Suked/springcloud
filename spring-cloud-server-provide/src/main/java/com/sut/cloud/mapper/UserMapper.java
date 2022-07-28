package com.sut.cloud.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sut.cloud.domain.vo.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<User> {
}
