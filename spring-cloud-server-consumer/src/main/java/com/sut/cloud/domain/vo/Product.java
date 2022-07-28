package com.sut.cloud.domain.vo;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName(value = "t_product")
public class Product extends BaseModel{
    private String title;

    private Long price;

    private Long userId;

    private User user;
}
