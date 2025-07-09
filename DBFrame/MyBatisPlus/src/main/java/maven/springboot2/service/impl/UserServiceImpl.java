package maven.springboot2.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import maven.springboot2.entity.User;
import maven.springboot2.mapper.UserMapper;
import maven.springboot2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional(rollbackFor = Exception.class)
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public IPage<User> findUserByIPage(long pageNum, long pageSize, int minAge) {
        IPage<User> userPage = new Page<>(pageNum, pageSize);
        userPage = userMapper.selectUserIPage(userPage,minAge);
        return userPage;
    }
}
