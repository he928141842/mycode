package com.hh.myproject.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hh.myproject.bean.People;
import com.hh.myproject.bean.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author hejiayuan
 * @date 2020-09-21 13:53
 */
@Repository
@Mapper
public interface TestDao extends BaseMapper<People> {
    String getInfo(Integer id);
}
