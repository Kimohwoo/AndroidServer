package com.android.Controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.android.DTO.UserDTO;
import com.android.mapper.UserMapper;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@RestController
@AllArgsConstructor
@Log4j
public class UserController {

	private final UserMapper userMapper;
	
	@GetMapping(value = "/android", produces = MediaType.APPLICATION_JSON_VALUE)
	public UserDTO get() {
		UserDTO user = userMapper.read("user1");
		return user;
	}
	
}
