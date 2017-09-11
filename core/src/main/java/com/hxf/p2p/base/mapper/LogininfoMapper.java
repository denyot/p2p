package com.hxf.p2p.base.mapper;

import com.hxf.p2p.base.domain.Logininfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface LogininfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Logininfo record);

    Logininfo selectByPrimaryKey(Integer id);

    List<Logininfo> selectAll();

    int updateByPrimaryKey(Logininfo record);

    /**
     * 根据用户名查询用户是否存在
     * @return
     * @param username
     */
    int getCountByUsername(String username);

    Logininfo login(@Param("username") String username, @Param("password") String password);
}