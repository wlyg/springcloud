package com.booting.test;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.booting.UserServerApplication;
import com.booting.pojo.User;

/**
 * Spring Data Redis测试
 *
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes=UserServerApplication.class)
public class RedisTest {

	@Autowired
	private RedisTemplate<String, Object> redisTemplate;
	
	/**
	 * 添加一个字符串
	 */
	@Test
	public void testSet(){
		this.redisTemplate.opsForValue().set("key", "北京尚学堂");
	}
	
	/**
	 * 获取一个字符串
	 */
	@Test
	public void testGet(){
		String value = (String)this.redisTemplate.opsForValue().get("key");
		System.out.println(value);
	}
	
	/**
	 * 添加Users对象
	 */
	@Test
	public void testSetUesrs(){
		User user = new User();
		user.setAge(20);
		user.setName("张三丰");
		user.setId(1);
		//重新设置序列化器
		this.redisTemplate.setValueSerializer(new JdkSerializationRedisSerializer());
		this.redisTemplate.opsForValue().set("users", user);
	}
	
	/**
	 * 取Users对象
	 */
	@Test
	public void testGetUsers(){
		//重新设置序列化器
		this.redisTemplate.setValueSerializer(new JdkSerializationRedisSerializer());
		User users = (User)this.redisTemplate.opsForValue().get("users");
		System.out.println(users);
	}
	
	/**
	 * 基于JSON格式存Users对象
	 */
	@Test
	public void testSetUsersUseJSON(){
		User user = new User();
		user.setAge(20);
		user.setName("李四丰");
		user.setId(1);
		this.redisTemplate.setValueSerializer(new Jackson2JsonRedisSerializer<>(User.class));
		this.redisTemplate.opsForValue().set("users_json", user);
	}
	
	/**
	 * 基于JSON格式取Users对象
	 */
	@Test
	public void testGetUseJSON(){
		this.redisTemplate.setValueSerializer(new Jackson2JsonRedisSerializer<>(User.class));
		User users = (User)this.redisTemplate.opsForValue().get("users_json");
		System.out.println(users);
	}
}
