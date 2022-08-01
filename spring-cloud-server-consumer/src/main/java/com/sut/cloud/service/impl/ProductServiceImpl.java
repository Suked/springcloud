package com.sut.cloud.service.impl;

import com.alibaba.fastjson.JSONPObject;
import com.alibaba.nacos.shaded.com.google.gson.JsonObject;
import com.stu.cloud.domain.AjaxResult;
import com.stu.cloud.utils.StringUtils;
import com.sut.cloud.clients.UserClient;
import com.sut.cloud.domain.vo.JsonResponse;
import com.sut.cloud.domain.vo.Product;
import com.sut.cloud.domain.vo.User;
import com.sut.cloud.mapper.ProductMapper;
import com.sut.cloud.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.Date;
import java.util.LinkedHashMap;

@Service
public class ProductServiceImpl implements IProductService {
    @Autowired
    private ProductMapper productMapper;

    @Autowired
    private UserClient userClient;


    @Override
    public Product findById(Long id) {
        Product product = productMapper.findById(id);
        if (StringUtils.isNull(product)){
            return null;
        }
        User user = userClient.findById(product.getId());

        product.setUser(user);

        return product;
    }
}
