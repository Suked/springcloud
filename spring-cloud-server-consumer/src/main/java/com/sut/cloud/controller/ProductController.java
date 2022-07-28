package com.sut.cloud.controller;

import com.stu.cloud.domain.AjaxResult;
import com.stu.cloud.utils.StringUtils;
import com.sut.cloud.domain.vo.Product;
import com.sut.cloud.service.impl.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {
    @Autowired
    private ProductServiceImpl productService;

    @GetMapping("{id}")
    public AjaxResult findById(@PathVariable("id") Long id){
        Product product = productService.findById(id);
        if (StringUtils.isNotNull(product)){
            return AjaxResult.success("订单查询成功", product);
        }
        return AjaxResult.error("订单查询有误");
    }

}
