package maven.spring.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.Data;
import maven.spring.entity.User;
import maven.spring.mapper.UserMapper;
import maven.spring.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

//@Transactional(rollbackFor = Exception.class)
@Service
@Data
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public IPage<User> findUserByIPage(long pageNum, long pageSize, int minAge) {
        IPage<User> userPage = new Page<>(pageNum, pageSize);
        userPage = userMapper.selectUserIPage(userPage,minAge);
        return userPage;
    }
}
