package com.itheima.test;

import com.itheima.damain.User;
import com.itheima.dao.UserDao;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class UserTest {

    private InputStream in;
    private  SqlSession session;
    private UserDao userDao;

    @Before //用于在测试方法执行之前执行
    public void init() throws IOException {
        //1.读取配置文件
        in= Resources.getResourceAsStream("SqlMapConfig.xml");
        //2.创建工厂
        SqlSessionFactory sf=new SqlSessionFactoryBuilder().build(in);
        //3.通过工厂创建对象
        session=sf.openSession();
        //4.创建代理对象
//        UserDao userDao=session.getMapper(UserDao.class);
        //5.使用代理对象创建方法
//        List<User>users=userDao.findAll();
        userDao=session.getMapper(UserDao.class);
    }

    @After
    public void destroy() throws Exception {
        session.commit();
        session.close();
        in.close();
    }

    @Test
    public void testFindAll() throws IOException {
        List<User>users= userDao.findAll();
        for(User user:users){
            System.out.println(user);
        }

    }



}
