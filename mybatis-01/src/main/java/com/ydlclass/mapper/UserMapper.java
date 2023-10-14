package com.ydlclass.mapper;

import com.ydlclass.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface UserMapper {
    List<User> selectAll();

    User selectOne(int id);
    User select(@Param("username") String username, @Param("password") String password);
    User selectUser( User user);
    User selectMap( Map<String,Object> map);

    List <User> selectLike( String i);
    int insert( User user);

    int update(@Param("username") String username,@Param("password")String password ,@Param("id")int id);

    int delete(int id);
}
