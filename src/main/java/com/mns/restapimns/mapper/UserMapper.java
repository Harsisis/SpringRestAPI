package com.mns.restapimns.mapper;

import org.springframework.stereotype.Service;

import com.mns.restapimns.entity.User;
import com.mns.restapimns.enums.Gender;
import com.mns.restapimns.structure.UserDTO;

@Service
public class UserMapper implements IMapper<User, UserDTO> {

	@Override
	public UserDTO toDto(User entity) {
		if (entity == null) {
			return null;
		}
		UserDTO userDto = new UserDTO();
		userDto.setId(entity.getId());
		userDto.setName(entity.getName());
		userDto.setFamilyName(entity.getFamilyName());
		userDto.setEmail(entity.getEmail());
		userDto.setGender(entity.getGender().name());

		return userDto;
	}

	@Override
	public User toEntity(UserDTO dto) {
		if (dto == null) {
			return null;
		}
		User user = new User();
		user.setId(dto.getId());
		user.setName(dto.getName());
		user.setFamilyName(dto.getFamilyName());
		user.setEmail(dto.getEmail());
		user.setGender(Gender.getOrNull(dto.getGender()));

		return user;
	}

}
