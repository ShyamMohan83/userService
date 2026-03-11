package com.move.userService.service;

import com.move.userService.mapper.AddressMapper;
import com.move.userService.mapper.ContactMapper;
import com.move.userService.mapper.UserMapper;
import com.move.userService.model.UserRegistrationDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private AddressMapper addressMapper;
    @Autowired
    private ContactMapper contactMapper;

    @Transactional
    public void userRegistration(UserRegistrationDTO userDto) {
        userMapper.insertUser(userDto.getUser());
        Long generatedKey = userDto.getUser().getUserId();
        userDto.getAddress().setUserId(generatedKey);
        userDto.getContact().setUserId(generatedKey);
        addressMapper.insertAddress(userDto.getAddress());
        contactMapper.insertContact(userDto.getContact());
    }
}
