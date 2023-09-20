package com.mns.restapimns.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.mns.restapimns.service.UserService;
import com.mns.restapimns.structure.UserDTO;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService service;


	@GetMapping("/findAll")
	public @ResponseBody List<UserDTO> findAll() {
		return service.findAll();
	}
	
	@GetMapping("/")
	public ModelAndView getUsersView() {
		return service.getUsersView();
	}
	
	@GetMapping("/find")
	public @ResponseBody UserDTO findById(@RequestHeader(name="id") int id) {
		return service.findById(id);
	}
	
	@PostMapping("/create")
	public @ResponseBody UserDTO create(@RequestBody UserDTO userDTO) {
		return service.create(userDTO);
	}
	
	@PutMapping("/update")
	public @ResponseBody UserDTO update(@RequestBody UserDTO userDTO) {
		return service.update(userDTO);
	}
	
	@DeleteMapping("/delete")
	public @ResponseBody Boolean delete(@RequestHeader(name="id") int id) {
		service.delete(id);
		return true;
	}
}
