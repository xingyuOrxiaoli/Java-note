package com.xiaoli.shiro;

import org.apache.shiro.crypto.hash.SimpleHash;

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
