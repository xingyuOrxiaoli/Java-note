package spring.ioc.service.ImpI;

import spring.ioc.service.TestService;

public class TestServiceImpI implements TestService {
    @Override
    public void testService() {
        System.out.println("TestServiceImpI  -> TestService  ");
    }
}
