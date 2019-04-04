package com.jiejie.dao;

import org.apache.ibatis.annotations.Param;

public interface User_RoleDao {

    //给指定用户添加角色
    void saveRole(@Param("uid") String uid, @Param("rid") String rid);
}
