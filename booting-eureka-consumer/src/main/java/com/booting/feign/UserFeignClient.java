package com.booting.feign;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.booting.pojo.User;

@FeignClient("eureka-provider")
public interface UserFeignClient {

	@RequestMapping(value = "/user", method = RequestMethod.GET)
	List getUser();
}
