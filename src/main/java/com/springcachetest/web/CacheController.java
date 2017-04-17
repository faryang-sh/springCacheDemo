package com.springcachetest.web;

import com.springcachetest.bean.ParamBean;
import com.springcachetest.bean.Person;
import com.springcachetest.service.CacheService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 杨志远[of2551]
 *         company qianmi.com
 *         Date    2017-03-14
 */
@RestController
@RequestMapping("/web")
@Slf4j
public class CacheController {

    @Autowired
    private CacheService cacheService;


    @RequestMapping(value = "/test1/{id}")
    public Person test1(@PathVariable Integer id) {
        Person p = cacheService.findById1(id+"");
        return p;
    }



    @RequestMapping(value = "/test2/{id}")
    public Person test2(@PathVariable Integer id) {
        Person p = cacheService.findById2(id);
        return p;
    }

    @RequestMapping(value = "/test3/{id}")
    public Person test3(@PathVariable Integer id) {
        Person p = cacheService.findById3(id+"","TwoParam");
        return p;
    }

    @RequestMapping(value = "/test4/{id}")
    public Person test4(@PathVariable Integer id) {
        ParamBean paramBean = new ParamBean();
        paramBean.setId(id);
        paramBean.setName("名称");
        paramBean.setNum(00);
        Person p = cacheService.findById4(paramBean);
        return p;
    }

    @RequestMapping(value = "/test5/{id}")
    public Person test5(@PathVariable int id) {

        Person p = cacheService.findById5(id);
        return p;
    }

    @RequestMapping(value = "/test11/{id}")
    public Person test11(@PathVariable Integer id) {
        Person p = cacheService.findById11(id);
        return p;
    }


    @RequestMapping(value = "/test12/{id}")
    public Person test12(@PathVariable Integer id) {
        Person p = cacheService.findById12(id);
        return p;
    }

    @RequestMapping(value = "/test2")
    public String test0() {
        return "ok";
    }


}
