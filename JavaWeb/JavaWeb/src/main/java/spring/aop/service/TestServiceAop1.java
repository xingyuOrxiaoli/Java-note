package spring.aop.service;

public class TestServiceAop1 implements TestServiceAop{

    @Override
    public void testA() {

        System.out.println("我是A对象的testA方法");
    }

    @Override
    public void testA(String username, String password) {
        System.out.println("testA :"+username+"  --  " + password);
    }

    @Override
    public void testAJ(String username,String uname) {

//        int i = 1/ 0 ;
        System.out.println("------ testAJ ------");
    }


}
