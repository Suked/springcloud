package com.sut.cloud.domain.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@TableName(value = "t_product")
@AllArgsConstructor
@NoArgsConstructor
public class Product implements Serializable {
    /** id自增 */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String title;
}
