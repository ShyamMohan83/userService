package com.move.userService.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.move.userService.mapper.AddressMapper;
import com.move.userService.mapper.ContactMapper;
import com.move.userService.mapper.UserMapper;
import com.move.userService.model.User;
import com.move.userService.model.UserDetailResponse;
import com.move.userService.model.UserRegistrationDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private AddressMapper addressMapper;
    @Autowired
    private ContactMapper contactMapper;
    @Autowired
    private ObjectMapper objectMapper;

    @Transactional
    public UserRegistrationDTO userRegistration(UserRegistrationDTO userDto) {
        userMapper.insertUser(userDto.getUser());
        Long generatedKey = userDto.getUser().getUserId();
        userDto.getAddress().setUserId(generatedKey);
        userDto.getContact().setUserId(generatedKey);
        addressMapper.insertAddress(userDto.getAddress());
        contactMapper.insertContact(userDto.getContact());
        return userDto;
    }

    public List<User> getAllUsers() {
        return userMapper.getAllUsers();
    }
    public UserDetailResponse getUserDetails(Long userId) {
        return  userMapper.getUserDetails(userId);
    }

    @Transactional
    public UserRegistrationDTO updateUserDetail(UserRegistrationDTO userDto, Long userId) {
        if(userDto.getUser().getUserId() != userId) throw new IllegalArgumentException("id mismatch");
        userDto.getUser().setUserId(userId);
        userDto.getAddress().setUserId(userId);
        userDto.getContact().setUserId(userId);
        userMapper.updateUser(userDto.getUser());
        addressMapper.updateAddress(userDto.getAddress());
        contactMapper.updateContact(userDto.getContact());
        return userDto;
    }

    @Transactional
    public User deleteUser(User user, Long userId) {
        if(user.getUserId() != userId) throw new IllegalArgumentException("Id mis-match");
        userMapper.deleteUser(user);
        return user;
    }
}
