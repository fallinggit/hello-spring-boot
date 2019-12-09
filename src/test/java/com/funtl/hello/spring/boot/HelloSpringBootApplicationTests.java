package com.funtl.hello.spring.boot;
import java.util.Date;

import com.funtl.hello.spring.boot.domain.TbUser;
import com.funtl.hello.spring.boot.mapper.TbUserMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
@Rollback
public class HelloSpringBootApplicationTests {

    @Autowired
    private TbUserMapper tbUserMapper;

    @Test
    public void contextLoads() {
        System.out.println("Hello Spring Boot");
    }

    @Test
    public void testSelectAll() {
        List<TbUser> tbUsers = tbUserMapper.selectAll();
        tbUsers.forEach(System.out::println);
    }

    @Test
    public void testInsert() {
        TbUser tbUser = new TbUser();
        tbUser.setUsername("Scorpio");
        tbUser.setPassword("123456");
        tbUser.setPhone("15888888888");
        tbUser.setEmail("scorpio@vip.qq.com");
        tbUser.setCreated(new Date());
        tbUser.setUpdated(new Date());

        tbUserMapper.insert(tbUser);
    }

    @Test
    public void testUpdate() {
        TbUser tbUser = tbUserMapper.selectByPrimaryKey(37L);
        tbUser.setUsername("Lusifer");

        tbUserMapper.updateByPrimaryKey(tbUser);
    }

    @Test
    public void testDelete() {
        tbUserMapper.deleteByPrimaryKey(39L);
    }

    @Test
    public void testPage() {
        Example example = new Example(TbUser.class);
        example.createCriteria().andLike("username","z%");

        PageHelper.startPage(1,5);
        PageInfo<TbUser> pageInfo = new PageInfo<>(tbUserMapper.selectByExample(example));

        System.out.println(pageInfo.getTotal());
        System.out.println(pageInfo.getPages());
        pageInfo.getList().forEach(System.out::println);
    }

}
