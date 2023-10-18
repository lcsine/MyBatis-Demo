package com.ydlclass.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee  implements Serializable {

    private static final Long serialVersionUID = 1L;

    private Integer id;
    private String name;
    //维护关系
    private Integer dId;
//    private String dname;
//    private Dept dept;
}