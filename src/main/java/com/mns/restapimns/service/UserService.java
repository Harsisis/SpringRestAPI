package com.mns.restapimns.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

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

	public List<UserDTO> findAll() {
		return repository.findAll().stream().map(user -> userMapper.toDto(user)).collect(Collectors.toList());
	}

	public UserDTO findById(int id) {
		return userMapper.toDto(repository.findById(id).get());
	}

	public UserDTO create(UserDTO userDTO) {
		return userMapper.toDto(repository.save(userMapper.toEntity(userDTO)));
	}
	
	public UserDTO update(UserDTO userDTO) {
		if(this.findById(userDTO.getId()) == null) {
			return null;
		}
		return userMapper.toDto(repository.save(userMapper.toEntity(userDTO)));
	}

	public void delete(int id) {
		User userToDelete = repository.findById(id).get();
		if(userToDelete == null) {
			return;
		}
		repository.delete(userToDelete);
	}

	public ModelAndView getUsersView() {
		ModelAndView mv=new ModelAndView("view/users");
		mv.addObject("users", this.findAll());
		
		return mv;
	}

}
