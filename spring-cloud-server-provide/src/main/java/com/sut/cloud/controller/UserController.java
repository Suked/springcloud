package com.sut.cloud.controller;

import com.stu.cloud.domain.AjaxResult;
import com.sut.cloud.config.PatternConfigProperties;
import com.sut.cloud.domain.vo.User;
import com.sut.cloud.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

@RestController
@RefreshScope
public class UserController {
    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private PatternConfigProperties properties;

    @Value("${config.info}")
    private String ConfigInfo;

    @GetMapping(value = "/now")
    public AjaxResult now(){
        String name = properties.getName();
        return AjaxResult.success(this.ConfigInfo);
    }

    @PostMapping("/register")
    public AjaxResult register(@RequestBody User user){
        int flag = userService.userAdd(user);
        if (0 == flag){
            return AjaxResult.error("注册失败");
        }
        return AjaxResult.success("注册成功");
    }

    @GetMapping("/qry/{id}")
    public AjaxResult findById(@PathVariable("id")Long id){
        User user = userService.findById(id);
        if (null == user){
            return AjaxResult.error("id不存在");
        }
        return AjaxResult.success(user);
    }

}
