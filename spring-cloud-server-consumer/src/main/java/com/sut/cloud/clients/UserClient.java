package com.sut.cloud.clients;

import com.sut.cloud.domain.vo.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("serverprovide")
public interface UserClient {

    @GetMapping("/qry/{id}")
    User findById(@PathVariable("id") Long id);
}
