package com.move.userService.mapper;

import com.move.userService.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserMapper {
    void insertUser(User user);
    User getUserById(@Param("userId") Long userId);
}
