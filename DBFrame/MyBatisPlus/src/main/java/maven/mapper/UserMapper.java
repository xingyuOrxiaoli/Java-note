package maven.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import maven.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper extends BaseMapper<UserMapper> {

    IPage<User> selectUserIPage(IPage page, @Param("age") Integer minAge);

    List<User> selectAllUser();
}
