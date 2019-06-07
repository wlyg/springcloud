package com.booting.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import com.booting.pojo.User;

/**
 * Repository   @Query
 *
 *
 */
public interface UsersRepositoryQueryAnnotation extends Repository<User, Integer> {

	@Query("from User where name = ?")
	List<User> queryByNameUseHQL(String name);
	
	@Query(value="select * from user where name = ?",nativeQuery=true)
	List<User> queryByNameUseSQL(String name);
	
	@Query("update User set name  = ? where id  = ?")
	@Modifying //需要执行一个更新操作
	void updateUsersNameById(String name,Integer id);
}
