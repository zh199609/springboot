package com.zl.controller;

import com.zl.config.ApiDefaultException;
import com.zl.config.ApiException;
import com.zl.config.ApiNotFindException;
import com.zl.config.NotFindPersonException;
import com.zl.entity.Person;
import com.zl.entity.enums.GradeEnum;
import com.zl.entity.enums.Sex;
import com.zl.mapper.PersonMapper;
import com.zl.service.PersonService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.IOException;
import java.util.Date;
import java.util.List;

/**
 * @ClassName: ApiController
 * @Description: Api接口
 * @Author: albertzh
 * @Create: 2019-10-16 15:03
 */
@Controller
@RequestMapping(value = "person")
public class ApiController {

    @Autowired
    private PersonService personService;

    @RequestMapping(value = "add")
    @ResponseBody
    public Person addEmp(@Valid @RequestBody Person person, BindingResult bindingResult, HttpServletRequest request) throws IOException {
        if (bindingResult.hasErrors()) {
            List<FieldError> fieldErrors = bindingResult.getFieldErrors();
            fieldErrors.forEach(fieldError -> System.out.println(fieldError.getDefaultMessage()));
        }
        try {
            personService.addPerson(person);
        } catch (NotFindPersonException e) {
            throw new ApiNotFindException(e.getMessage());
        } catch (Exception e) {
            throw new ApiException(e);
        }
        return person;
    }


    @RequestMapping(value = "/testHttp")
    @ResponseBody
    public Person testHttp(HttpServletRequest request) {
        Person person = new Person();
        person.setId(1L);
        person.setName("setName");
        person.setAge(24);
        person.setCreateTime(new Date());
        person.setGrade(GradeEnum.HIGH);
        person.setSex(Sex.female);
        return person;
    }
}
