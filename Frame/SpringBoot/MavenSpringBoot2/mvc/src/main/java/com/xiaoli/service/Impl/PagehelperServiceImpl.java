package com.xiaoli.service.Impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.xiaoli.mapper.PagehelperMapper;
import com.xiaoli.pojo.Test1;
import com.xiaoli.service.PagehelperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;

@Service
@Transactional
public class PagehelperServiceImpl implements PagehelperService {

    @Autowired
    private PagehelperMapper pagehelperMapper;

    @Override
    public List<Test1> findTest1InfoPage() {
        Page<Test1> page = PageHelper.startPage(2, 2);
        System.out.println(page.getTotal());
        System.out.println(page.getPages());
        return pagehelperMapper.selectInfo();
    }
}
