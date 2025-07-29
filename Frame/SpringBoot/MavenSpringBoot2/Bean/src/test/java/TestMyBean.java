import com.xiaoli.BeanApplication;
import com.xiaoli.pojo.User;
import com.xiaoli.pojo.User2;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = BeanApplication.class)
public class TestMyBean {


    @Autowired
    private User u1;
    @Autowired
    private User u2;
    @Autowired
    private User2 User2_1;

    @Test
    public void testBean1(){
        System.out.println(u1);
        System.out.println("==========================");
        System.out.println(u2);
    }

    // 依赖注入
    @Test
    public void testBean2(){
        System.out.println(User2_1);
    }
}
