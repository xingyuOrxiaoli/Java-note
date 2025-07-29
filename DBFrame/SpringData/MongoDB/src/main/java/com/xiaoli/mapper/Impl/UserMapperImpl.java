package com.xiaoli.mapper.Impl;

import com.xiaoli.mapper.UserMapper;
import com.xiaoli.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Repository
public class UserMapperImpl implements UserMapper {


    @Autowired
    private MongoTemplate mongoTemplate;


    @Override
    public int insert(User user) {
        User save = this.mongoTemplate.save(user);
//        User insert = this.mongoTemplate.insert(user);
        System.out.println(save);
        return 0;
    }

    @Override
    public int updateById(User user) {

        Query query = new Query();
        query.addCriteria(
                Criteria.where("id").is(user.getId())
        );
        Update update = new Update();
        update.set("password",user.getPassword());


        this.mongoTemplate.updateFirst(query,update,User.class);

        return 0;
    }

    @Override
    public int delete(User user) {

        this.mongoTemplate.remove(user);

        return 0;
    }

    @Override
    public int deleteById(Integer id) {
        Query query = new Query();
        query.addCriteria(
                Criteria.where("id").is(id)
        );
        this.mongoTemplate.remove(query,User.class);
        return 0;
    }

    @Override
    public int deleteByIds(List<Integer> ids) {
        Query query = new Query();
        query.addCriteria(
                Criteria.where("id").in(ids)
        );
        this.mongoTemplate.remove(query,User.class);
        return 0;
    }

    @Override
    public User findById(Integer id) {
        User user = this.mongoTemplate.findById(id,User.class);
        return user;
    }

    @Override
    public List<User> findByUserName(String username) {
        Query query = new Query();
        query.addCriteria(
                Criteria.where("username").is(username)
                        .andOperator(Criteria.where("password").is("password1")
                        )
        );

        Sort sort = Sort.by(new Sort.Order(Sort.Direction.ASC, "username"));
        query.with(PageRequest.of(0,2,sort));
//        query.with(sort);
        List<User> list = this.mongoTemplate.find(query,User.class);
        return list;
    }

    @Override
    public List<User> findAll() {
        List<User> list = this.mongoTemplate.findAll(User.class);
        return list;
    }
}
