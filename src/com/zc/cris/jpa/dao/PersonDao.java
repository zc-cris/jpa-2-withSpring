package com.zc.cris.jpa.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.zc.cris.jpa.spring.entities.Person;

@Repository
public class PersonDao {

	/*
	 * 如何获取到和当前事务关联的 EntityManager 对象？ 
	 * 通过 @PersistenceContext 这个注解来标记成员变量即可
	 */
	@PersistenceContext
	private EntityManager entityManager;

	public void save(Person person) {
		entityManager.persist(person);
	}

}
