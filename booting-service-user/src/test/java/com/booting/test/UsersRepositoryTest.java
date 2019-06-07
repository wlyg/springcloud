package com.booting.test;

import java.util.List;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.booting.UserServerApplication;
import com.booting.dao.UsersRepository;
import com.booting.dao.UsersRepositoryByName;
import com.booting.dao.UsersRepositoryQueryAnnotation;
import com.booting.pojo.User;

/**
 * 测试类
 *
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = UserServerApplication.class)
public class UsersRepositoryTest {

	@Autowired
	private UsersRepository usersRepository;

	@Autowired
	private UsersRepositoryByName usersRepositoryByName;

	@Autowired
	private UsersRepositoryQueryAnnotation usersRepositoryQueryAnnotation;

	@Test
	public void testSave() {
		User users = new User();
		users.setAddress("上海市");
		users.setAge(24);
		users.setName("王五");
		this.usersRepository.save(users);
	}

	/**
	 * Repository--方法名称命名测试
	 */
	@Test
	public void testFindByName() {
		List<User> list = this.usersRepositoryByName.findByName("张三");
		for (User users : list) {
			System.out.println(users);
		}
	}

	/**
	 * Repository--方法名称命名测试
	 */
	@Test
	public void testFindByNameAndAge() {
		List<User> list = this.usersRepositoryByName.findByNameAndAge("张三", 20);
		for (User users : list) {
			System.out.println(users);
		}
	}

	/**
	 * Repository--方法名称命名测试
	 */
	@Test
	public void testFindByNameLike() {
		List<User> list = this.usersRepositoryByName.findByNameLike("张%");
		for (User users : list) {
			System.out.println(users);
		}
	}

	/**
	 * Repository--@Query测试
	 */
	@Test
	public void testQueryByNameUseHQL() {
		List<User> list = this.usersRepositoryQueryAnnotation.queryByNameUseHQL("张三");
		for (User users : list) {
			System.out.println(users);
		}
	}

	/**
	 * Repository--@Query测试
	 */
	@Test
	public void testQueryByNameUseSQL() {
		List<User> list = this.usersRepositoryQueryAnnotation.queryByNameUseSQL("张三");
		for (User users : list) {
			System.out.println(users);
		}
	}

	/**
	 * Repository--@Query测试
	 */
	@Test
	@Transactional //@Transactional与@Test 一起使用时 事务是自动回滚的。
	@Rollback(false) //取消自动回滚
	public void testUpdateUsersNameById() {
		this.usersRepositoryQueryAnnotation.updateUsersNameById("张三三", 1);
	}

}
