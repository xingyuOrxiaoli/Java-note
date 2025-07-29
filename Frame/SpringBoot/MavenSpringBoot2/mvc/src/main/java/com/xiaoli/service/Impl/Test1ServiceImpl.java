package com.xiaoli.service.Impl;

import com.xiaoli.mapper.Test1Mapper;
import com.xiaoli.pojo.Test1;
import com.xiaoli.service.Test1Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class Test1ServiceImpl implements Test1Service {

    @Autowired
    private Test1Mapper test1Mapper;

    @Override
    public List<Test1> findTest1All(){
        return test1Mapper.selectTest1All();
    }
}
