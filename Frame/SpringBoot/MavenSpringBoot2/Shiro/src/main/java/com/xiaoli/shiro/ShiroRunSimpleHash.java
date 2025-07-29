package com.xiaoli;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.ini.IniSecurityManagerFactory;
import org.apache.shiro.lang.util.Factory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;

public class ShiroRunSimpleHash {
    public static void main(String[] args) {

        // 一般情况是请求获取的
        String password = "password";
        // md5加密  盐 迭代次数
        SimpleHash simpleHash1 = new SimpleHash("SHA-256" , password,"salt",2);
        System.out.println(simpleHash1);
        SimpleHash simpleHash2 = new SimpleHash("MD5" , password,"salt",2);
        System.out.println(simpleHash2);

    }
}
