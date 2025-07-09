package maven.spring;

import com.baomidou.mybatisplus.core.metadata.IPage;
import maven.spring.entity.User;
import maven.spring.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class SpringApplication {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:maven/spring/MyBatisPlus.xml");
        System.out.println("===============================================================================================");
        UserService userService = context.getBean("userServiceImpl", UserService.class);
        IPage<User> serviceUserByIPage = userService.findUserByIPage(2, 2, 2);
        List<User> records = serviceUserByIPage.getRecords();
        records.forEach(System.out::println);
        System.out.println("===============================================================================================");
        System.out.println("总数： " + serviceUserByIPage.getTotal());
    }
}
