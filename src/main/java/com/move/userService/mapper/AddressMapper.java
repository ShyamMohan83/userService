package com.move.userService.mapper;

import com.move.userService.model.Address;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface AddressMapper {
    void insertAddress(Address address);
    Address getAddressByUserId(@Param("userId") Long userId);
    public void updateAddress(Address address);
}
