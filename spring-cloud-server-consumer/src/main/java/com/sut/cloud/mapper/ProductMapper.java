package com.sut.cloud.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sut.cloud.domain.vo.Product;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ProductMapper extends BaseMapper<Product> {

    Product findById(@Param("id") Long id);

}
