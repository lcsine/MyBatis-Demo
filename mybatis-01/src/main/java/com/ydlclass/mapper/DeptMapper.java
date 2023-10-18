package com.ydlclass.mapper;

import com.ydlclass.entity.Dept;

import java.util.List;

public interface DeptMapper {
    Dept selectById(Integer dId) ;
    List<Dept> selectD(Integer dId) ;
    List<Dept> selectAll(Dept dept) ;
}
