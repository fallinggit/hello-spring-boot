package com.funtl.hello.spring.boot.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.funtl.hello.spring.boot.mapper.TbUserMapper;
import com.funtl.hello.spring.boot.service.TbUserService;
@Service
public class TbUserServiceImpl implements TbUserService{

    @Resource
    private TbUserMapper tbUserMapper;

}
