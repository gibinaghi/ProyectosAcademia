package com.ayi.curso.rest.serv.ayispringrestful.controller;

import com.ayi.curso.rest.serv.ayispringrestful.entity.Users;
import com.ayi.curso.rest.serv.ayispringrestful.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@CrossOrigin(origins = "http://localhost:3306")
@RestController
@RequestMapping("/api")
public class UsersController {
	
	@Autowired
	private UserService usersService;
	
	// Get all 
    @GetMapping("/users")
    public List<Users> fetchUserList()
    {
        return usersService.fetchUserList();
    }
    
    // Create
    @PostMapping("/user")
    public Users saveUser(@RequestBody Users user)
    {
        return usersService.saveUser(user);
    }
    
    // Update
    @PatchMapping("/user/{id}")
    public Users updateUser(
    		@RequestBody Users user,
            @PathVariable("id") Long id)
    {
        return usersService.updateUser(user, id);
    }
 
    // Delete
    @DeleteMapping("/user/{id}")
    public String deleteUserById(@PathVariable("id") Long id)
    {
    	try {
    	usersService.deleteUsertById(id);
        return "Deleted Successfully";
    	}catch(Exception e){
    		return "ERROR: No deleted";
    	}
    }
    
    // Search by name 
    @GetMapping("/users/{name}")
    public List<Users> searchByName(@PathVariable("name") String name)
    {
        return usersService.searchByName(name);
    }
}
