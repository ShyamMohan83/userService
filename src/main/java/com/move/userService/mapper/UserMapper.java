package com.move.userService.mapper;

import com.move.userService.model.Contact;
import com.move.userService.model.User;
import com.move.userService.model.UserDetailResponse;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserMapper {
    public void insertUser(User user);
    public User getUserById(@Param("userId") Long userId);

    public List<User> getAllUsers();
    public UserDetailResponse getUserDetails(@Param("userId") Long userId);
    public void updateUser(User user);

    public void deleteUser(User user);
}
