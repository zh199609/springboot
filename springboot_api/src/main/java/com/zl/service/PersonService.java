package com.zl.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zl.config.NotFindPersonException;
import com.zl.entity.Person;
import com.zl.mapper.PersonMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName: PersonService
 * @Description: personService
 * @Author: albertzh
 * @Create: 2019-10-16 15:04
 */
@Service
public class PersonService {
    @Autowired
    private PersonMapper personMapper;

    public void addPerson(Person person) {
        if (person.getAge() > 25) {
            throw new NotFindPersonException("找不到该用户！");
        }
        personMapper.insert(person);
    }
}
