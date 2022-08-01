package com.sut.cloud.domain.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {
    private Integer id;

    private String name;

    private String password;

    private String gender;

    private Integer age;

    private String phone;

    private String email;

    private Integer status;

    private String img;

    @JsonFormat(pattern = "yyyy:MM:dd HH:mm:ss")
    private String createdTime;

}
