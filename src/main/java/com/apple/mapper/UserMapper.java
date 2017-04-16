package com.apple.mapper;

import org.springframework.stereotype.Component;

import com.apple.dtos.request.UserRequestDTO;
import com.apple.dtos.response.UserResponseDTO;
import com.apple.entity.User;

import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.ConfigurableMapper;

@Component
public class UserMapper extends ConfigurableMapper implements Imapper {
 
	 @Override
	 public void configure(MapperFactory mapperFactory) {
	   mapperFactory.classMap(User.class, UserRequestDTO.class);
	   mapperFactory.classMap(User.class, UserResponseDTO.class);
	   mapperFactory.classMap(UserRequestDTO.class, User.class);
	   mapperFactory.classMap(UserResponseDTO.class, User.class);
	 }
}
