package com.ydlclass.mapper;

import com.ydlclass.entity.Admin;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface AdminMapper {


    @Insert("insert into admin (username,password) values (#{username},#{password})")
    int saveAdmin(Admin admin);


    @Update("update admin set username=#{username} , password=#{password} where id = #{id}")
    int updateAdmin(Admin admin);


    @Delete("delete from admin where id=#{id}")
    int deleteAdmin(int id);

    @Select("select id,username,password from admin where id=#{id}")
    Admin findAdminById(@Param("id") int id);


    @Select("select id,username,password from admin")
    List<Admin> findAllAdmins();

}

