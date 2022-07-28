package com.sut.cloud.service;

import com.sut.cloud.domain.vo.Product;

public interface IProductService {
    Product findById(Long id);
}
