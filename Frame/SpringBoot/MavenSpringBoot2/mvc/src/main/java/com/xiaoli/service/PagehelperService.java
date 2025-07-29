package com.xiaoli.service;

import com.xiaoli.pojo.Test1;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PagehelperService {
    List<Test1> findTest1InfoPage();
}
