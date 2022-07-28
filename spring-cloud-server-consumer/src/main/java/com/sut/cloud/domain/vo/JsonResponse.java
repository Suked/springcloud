package com.sut.cloud.domain.vo;

import lombok.Data;

@Data
public class JsonResponse<T> {
    private String msg;

    private Integer code;

    private T data;
}
