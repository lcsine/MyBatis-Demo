package com.ydlclass.mapper.impl;

import com.ydlclass.entity.User;
import com.ydlclass.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class UserMapperImpl {
    public static final Logger  LOGGER = LoggerFactory.getLogger(UserMapperImpl.class);

    public List<User> selectAll() {
        String resource = "mybatis-config.xml";
        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream(resource);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        try (SqlSession session = sqlSessionFactory.openSession()) {
            List<Object> objects = session.selectList(UserMapper.class.getName()+".selectAll");
            System.out.println(objects);
        }
        return null;
    }

    public static void main(String[] args) {
        UserMapperImpl userMapper = new UserMapperImpl();
        userMapper.selectAll();
    }
}
