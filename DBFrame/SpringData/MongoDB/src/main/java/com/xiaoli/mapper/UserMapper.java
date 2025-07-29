package com.xiaoli.mapper;

import com.xiaoli.pojo.User;

import java.util.List;

public interface UserMapper {

    public int insert(User user);
    public int updateById(User user);
    public int delete(User user);
    public int deleteById(Integer id);
    public int deleteByIds(List<Integer> ids);

    public User findById(Integer id);
    public List<User> findByUserName(String username);
    public List<User> findAll();


}
