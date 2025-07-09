package maven.springboot2.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import maven.springboot2.entity.User;

public interface UserService {

    IPage<User> findUserByIPage(long pageNum, long pageSize, int minAge);
}
