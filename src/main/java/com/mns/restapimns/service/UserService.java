package com.mns.restapimns.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mns.restapimns.entity.User;
import com.mns.restapimns.mapper.UserMapper;
import com.mns.restapimns.repository.UserRepository;
import com.mns.restapimns.structure.UserDTO;

@Service
public class UserService {
	
	@Autowired
	private UserMapper userMapper;
	
	@Autowired
	private UserRepository repository;

	public List<User> findAll() {
		return repository.findAll();
	}

	public User findById(int id) {
		return repository.findById(id).get();
	}

	public User create(UserDTO userDTO) {
		return repository.save(userMapper.toEntity(userDTO));
	}
	
	public User update(UserDTO userDTO) {
		if(this.findById(userDTO.getId()) == null) {
			return null;
		}
		return repository.save(userMapper.toEntity(userDTO));
	}

	public void delete(int id) {
		User userToDelete = this.findById(id);
		if(userToDelete == null) {
			return;
		}
		repository.delete(userToDelete);
	}

}
