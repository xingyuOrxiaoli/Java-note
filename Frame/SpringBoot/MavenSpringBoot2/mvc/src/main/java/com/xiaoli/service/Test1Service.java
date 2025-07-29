package com.xiaoli.service;

import com.xiaoli.mapper.Test1Mapper;
import com.xiaoli.pojo.Test1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface Test1Service {


    List<Test1> findTest1All();
}
