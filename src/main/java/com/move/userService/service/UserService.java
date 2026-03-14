package com.move.userService.service;

import com.fasterxml.jackson.databind.ObjectMapper;
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
    @Autowired
    private ObjectMapper objectMapper;

    @Transactional
    public void userRegistration(UserRegistrationDTO userDto) {
        try{
            String json = objectMapper.writerWithDefaultPrettyPrinter()
                    .writeValueAsString(userDto);
            System.out.println("========== FULL INCOMING JSON OBJECT ==========");
            System.out.println(json);
            System.out.println("===============================================");
        } catch (Exception e) {
            System.out.println(e);
        }

        System.out.println("User instering..");
        userMapper.insertUser(userDto.getUser());
        Long generatedKey = userDto.getUser().getUserId();
        System.out.println(generatedKey);
        userDto.getAddress().setUserId(generatedKey);
        userDto.getContact().setUserId(generatedKey);
        addressMapper.insertAddress(userDto.getAddress());
        contactMapper.insertContact(userDto.getContact());
    }
}
