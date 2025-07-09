package spring.aop.service;

public class TestServiceAop2 implements TestServiceAop{
    @Override
    public void testA() {

        System.out.println("扩展前");
        TestServiceAop testServiceAop = new TestServiceAop1();
        testServiceAop.testA();
        System.out.println("扩展后");
    }

    @Override
    public void testA(String username, String password) {

    }

    @Override
    public void testAJ(String username, String uname) {

    }


}
