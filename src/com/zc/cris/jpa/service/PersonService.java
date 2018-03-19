package com.zc.cris.jpa.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zc.cris.jpa.dao.PersonDao;
import com.zc.cris.jpa.spring.entities.Person;

@Service
public class PersonService {

	@Autowired
	private PersonDao personDao;

	// 注意是 springframework 下的注解，不是 javax的注解
	@Transactional
	public void savePersons(Person person1, Person person2) {
		personDao.save(person1);
//		int i = 10/0;
		personDao.save(person2);
	}

}
