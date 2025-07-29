package com.xiaoli.eHCache;


import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;

public class TestEH {
    public static void main(String[] args) {
        // 获取当前系统的缓存目录
        System.out.println(System.getProperty("java.io.tmpdir"));

//        D:\note\github\Java-note\Frame\SpringBoot\MavenSpringBoot2\Shiro\src\main\resources\ehcache.xml
        // 使用EH完成数据库的缓存和获取
        // 缓存数据s
        CacheManager cacheManager = new CacheManager(System.getProperty("user.dir")+"/Shiro/src/main/resources/ehcache.xml");
        // 缓存数据
        Cache cache1 = cacheManager.getCache("HelloWorldCache");
        Element element = new Element("name","xiaoli");
        cache1.put(element);


        // 获取缓存数据
        Element element1 = cache1.get("name");
        System.out.println(element1);


    }
}
