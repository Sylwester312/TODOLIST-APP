package com.example.demo.Mappers.impl;

import com.example.demo.Mappers.Mapper;
import com.example.demo.dto.request.AccountSignUp;
import com.example.demo.entity.User;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class UserMapperImpl implements Mapper<User, AccountSignUp> {

    private ModelMapper modelMapper;

    @Override
    public AccountSignUp mapTo(User userEntity) {
        return modelMapper.map(userEntity, AccountSignUp.class);
    }

    @Override
    public User mapFrom(AccountSignUp accountSignUp) {
        return modelMapper.map(accountSignUp, User.class);
    }
}
