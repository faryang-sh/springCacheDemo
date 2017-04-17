package com.springcachetest.dao;

import com.springcachetest.bean.Person;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 杨志远[of2551]
 *         company qianmi.com
 *         Date    2017-03-14
 */

@Component
public class CacheDao {
    private static Map<Integer,Person> peoples=new HashMap<>();
    static {
        for (int i = 0; i < 3; i++) {
            Person p = Person.builder()
                    .name("王" + i)
                    .id(i)
                    .sex(i%2==1?"男":"女")
                    .build();
            peoples.put(i,p);
        }
        System.out.println("------------dao----------------");
    }

    public Person  findById(int id) {

        return peoples.get(id);

    }
}
