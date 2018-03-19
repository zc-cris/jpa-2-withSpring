package com.zc.cris.jpa.spring;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zc.cris.jpa.service.PersonService;
import com.zc.cris.jpa.spring.entities.Person;

class TestJPAWithSpring {

	ApplicationContext context = null;
	private PersonService personService = null;

	{
		context = new ClassPathXmlApplicationContext("applicationContext.xml");
		personService = context.getBean(PersonService.class);
	}

	
	@Test
	void testPersonService() {
		Person p1 = new Person();
		p1.setAge(12);
		p1.setEmail("123@qq.com");
		p1.setName("james");
		
		Person p2 = new Person();
		p2.setAge(22);
		p2.setEmail("34343@qq.com");
		p2.setName("哈登");
		
		// 打印这句话的目的就是证明事务已经加上了，因为打印出来的是 代理对象
		System.out.println(personService.getClass().getName());
		personService.savePersons(p1, p2);
		
	}
	
	@Test
	void test() throws SQLException {
		
	
		DataSource bean = context.getBean(DataSource.class);
		System.out.println(bean.getConnection());
		
	}
}
