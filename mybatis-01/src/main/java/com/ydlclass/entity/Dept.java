package com.ydlclass.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Dept  implements Serializable {

    private static final Long serialVersionUID = 1L;

    private int id;
    private String name;

}