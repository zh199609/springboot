package com.zl.controller;

import com.zl.config.ApiDefaultException;
import com.zl.config.ApiException;
import com.zl.config.ApiNotFindException;
import com.zl.config.NotFindPersonException;
import com.zl.entity.Person;
import com.zl.mapper.PersonMapper;
import com.zl.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;

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
    public Person addEmp(@Valid @RequestBody Person person, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            System.out.println("error:" + bindingResult.getFieldErrors());
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
}
