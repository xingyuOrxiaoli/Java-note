package com.xiaoli.shiro;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.ini.IniSecurityManagerFactory;
import org.apache.shiro.lang.util.ByteSource;
import org.apache.shiro.lang.util.Factory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.realm.AuthenticatingRealm;
import org.apache.shiro.subject.Subject;

// 自定义认证规则
public class ShiroRunRealm extends AuthenticatingRealm {


    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        // 1. 获取认证的身份（唯一的）
        String username = authenticationToken.getPrincipal().toString();
        // 2。 身份验证
        if("xiaoli".equals(username)) { // 假设用户名是从数据库中获取的
            // 3. 身份验证通过后验证用户凭证
            String password = new String((char[])authenticationToken.getCredentials()); // 用户在页面书写的密钥
            String databases_password = "xiaoli"; // 从数据库获取的密码

            // 获取数据的ID
            Long id = 0l;

            // 4. 验证密钥
            SimpleAuthenticationInfo realmname = new SimpleAuthenticationInfo(
                    authenticationToken.getPrincipal()
                    , databases_password
                    , ByteSource.Util.bytes(id+"")
                    ,"realmname"
            );

            return realmname;
        }

        return null; // 验证失败
    }
    public static void main(String[] args) {

        Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro.ini");
        SecurityManager securityManager = factory.getInstance();
        SecurityUtils.setSecurityManager(securityManager);
        Subject subject = SecurityUtils.getSubject();
        AuthenticationToken token = new UsernamePasswordToken("xiaoli", "xiaoli");

        subject.login(token);
        System.out.println("登录成功");

    }

}
