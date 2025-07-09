package maven.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import maven.entity.User;

public interface UserService {

    IPage<User> findUserByIPage(long pageNum,long pageSize,int minAge);
}
