package com.hh.myproject.bean;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author hejiayuan
 * @date 2021-01-13 14:18
 */
@Data
@TableName("mydb.testtable")
@AllArgsConstructor
public class People {
    private String id;
    private String name;
}
