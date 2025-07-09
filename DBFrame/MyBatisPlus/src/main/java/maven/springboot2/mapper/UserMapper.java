package maven.springboot2.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import maven.springboot2.entity.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserMapper extends BaseMapper<User> {


    @Select("select * from user where user.age &gt;=#{age}")
    IPage<User> selectUserIPage(IPage page, @Param("age") Integer minAge);
}
