package maven.spring.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import maven.spring.entity.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    IPage<User> findUserByIPage(long pageNum, long pageSize, int minAge);
}
