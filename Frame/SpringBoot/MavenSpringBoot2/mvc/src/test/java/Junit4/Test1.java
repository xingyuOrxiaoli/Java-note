package Junit4;


import com.xiaoli.XiaoLiApplication;
import com.xiaoli.service.Test1Service;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = XiaoLiApplication.class)
public class Test1 {

    @Autowired
    private Test1Service test1Service;

    @Test
    public void Test_findTest1All(){
        test1Service.findTest1All().forEach(System.out::println);
    }

}
