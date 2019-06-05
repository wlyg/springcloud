package com.booting.dao;

import java.util.List;

import org.springframework.data.repository.Repository;

import com.booting.pojo.User;

/**
 * Repository接口的方法名称命名查询
 *
 *
 */
public interface UsersRepositoryByName extends Repository<User, Integer> {

	//方法的名称必须要遵循驼峰式命名规则。findBy(关键字)+属性名称(首字母要大写)+查询条件(首字母大写)
	List<User> findByName(String name);
	
	List<User> findByNameAndAge(String name,Integer age);
	
	List<User> findByNameLike(String name);
}
