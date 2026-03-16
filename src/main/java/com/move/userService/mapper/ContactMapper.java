package com.move.userService.mapper;

import com.move.userService.model.Contact;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ContactMapper {
    public void insertContact(Contact contact);
    public Contact getContactById(@Param("userId") Long userId);
    public void updateContact(Contact contact);

}
