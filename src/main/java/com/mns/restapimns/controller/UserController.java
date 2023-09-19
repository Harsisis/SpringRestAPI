package com.mns.restapimns.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.mns.restapimns.entity.User;
import com.mns.restapimns.service.UserService;
import com.mns.restapimns.structure.UserDTO;

@RestController
public class UserController {

	@Autowired
	private UserService service;


	@GetMapping("/user/findAll")
	public @ResponseBody List<User> findAll() {
		return service.findAll();
	}
	
	@GetMapping("/user/find")
	public @ResponseBody User findById(@RequestHeader(name="id") int id) {
		return service.findById(id);
	}
	
	@PostMapping("/user/create")
	public @ResponseBody User create(@RequestBody UserDTO userDTO) {
		return service.create(userDTO);
	}
	
	@PutMapping("/user/update")
	public @ResponseBody User update(@RequestBody UserDTO userDTO) {
		return service.update(userDTO);
	}
	
	@DeleteMapping("/user/delete")
	public @ResponseBody Boolean delete(@RequestHeader(name="id") int id) {
		service.delete(id);
		return true;
	}
}
