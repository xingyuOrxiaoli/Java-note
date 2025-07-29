package com.xiaoli.shiro;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.ini.IniSecurityManagerFactory;
import org.apache.shiro.lang.util.Factory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;

import java.util.ArrayList;
import java.util.Arrays;

public class ShiroRunAuthorizer {
    public static void main(String[] args) {
        // 1. 获取SecurityManager的工厂对象
        Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro.ini");
        // 2. 生产securityManager
        SecurityManager securityManager = factory.getInstance();
        // 3. 将securityManager对象存储到securityUtils中，保证securityManager中
        //  一次请求内的任意位置获取的是同一个securityManager对象，不同的请求获取的是不同的
        SecurityUtils.setSecurityManager(securityManager);
        // 4. 获取subject对象完成认证
        Subject subject = SecurityUtils.getSubject();
        // 5. 常见认证信息对象，促成农户认证数据
        AuthenticationToken token = new UsernamePasswordToken("xiaoli", "xl");
        // 6. 完成认证操作
        try {
            subject.login(token);
            System.out.println("登录成功");
            // 授权
            boolean role1 = subject.hasRole("role1");
            System.out.println(role1); // 是否有role1的权限
            ArrayList<String> list = new ArrayList<>();
            list.add("role1");
            list.add("role2");
            list.add("role3");
            boolean[] flagList = subject.hasRoles(list);
            System.out.println(Arrays.toString(flagList));
            // 权限的验证
//            subject.checkPermission("permission1"); // 单个权限 不存在报错
//            subject.checkPermission("permission3");
//            subject.checkPermissions("permission1" , "permission2");

            // 判定是否存在 返回布尔
            boolean permitted = subject.isPermitted("user:insert");
            System.out.println(permitted);


        }catch (UnknownAccountException e){
            System.out.println("账号不存在");
        }catch (IncorrectCredentialsException e){
            System.out.println("密码不存在");
        }catch (AuthenticationException e){
            e.printStackTrace();
        }


    }
}
