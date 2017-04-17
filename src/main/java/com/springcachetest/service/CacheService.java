package com.springcachetest.service;

import com.springcachetest.bean.ParamBean;
import com.springcachetest.bean.Person;
import com.springcachetest.dao.CacheDao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

/**
 * @author 杨志远[of2551]
 *         company qianmi.com
 *         Date    2017-03-14
 */

@Component
//@CacheConfig(cacheNames = "person",keyGenerator = "wiselyKeyGenerator")
@Slf4j
public class CacheService {


    @Autowired
    private CacheDao cacheDao;

    /**
     * 不指定key生成器，单个入参为String类型
     *
     * @param id
     * @return
     */
    @Cacheable(value = "personCache")
    public Person findById1(String id) {
        log.info(String.format("findById1方法缓存命中失败,id=[%s])",id));
        return cacheDao.findById(Integer.parseInt(id));
    }

    /**
     * 不指定key生成器，单个入参为Integer类型
     * --需要将显示设置key，并将参数转换为String类型
     * --否则出现ClassCastException：Integer无法转换为String.
     *
     * @param id
     * @return
     */
    @Cacheable(value = "personCache",key = "#id+''")
    public Person findById2(Integer id) {
        log.info(String.format("findById1方法缓存命中失败,id=[%s])",id));
        return cacheDao.findById(id);
    }

    /**
     * 不指定key生成器，有多个入参
     * --需要在RedisConfig中重写keyGenerator()方法,
     * --否则会出现ClassCastException：SimpleKey无法转换为String.
     * --原因：https://docs.spring.io/spring/docs/current/spring-framework-reference/html/cache.html#cache-annotations-cacheable-default-key
     *
     * @param id
     * @param moreParam
     * @return
     */
    @Cacheable(value = "personCache")
    public Person findById3(String id, String moreParam) {
        return cacheDao.findById(Integer.parseInt(id));
    }

    /**
     * 不指定key生成器，有单个入参，入参为自定义类型
     * --出现转换异常
     *
     * @param paramBean
     * @return
     */
    @Cacheable(value = "personCache")
    public Person findById4(ParamBean paramBean) {
        return cacheDao.findById(paramBean.getId());
    }

    /**
     * 不指定key生成器，有单个入参，入参为基本类型
     * --出现转换异常
     *
     * @param id
     * @return
     */
    @Cacheable(value = "personCache")
    public Person findById5(int id) {
        return cacheDao.findById(id);
    }



    @Cacheable(value = "addresscache",keyGenerator = "wiselyKeyGenerator")
    public Person findById11(Integer id){
        log.info(String.format("findById1方法缓存命中失败,id=[%s])",id));
        return cacheDao.findById(id);
    }


    public Person findById12(Integer id) {
        log.info(String.format("findById2方法缓存命中失败,id=[%s])",id));
        return doQuery(id);
    }

    @Cacheable(value = "addresscache",keyGenerator = "wiselyKeyGenerator")
    public Person doQuery(Integer id) {
        log.info(String.format("doQuery方法缓存命中失败,id=[%s])",id));
        return cacheDao.findById(id);
    }

    @CacheEvict(value ="addresscache",key = "#key")
    public void evict(String key) {
        log.info(key);
    }


}
