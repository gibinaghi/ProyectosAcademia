package com.ayi.curso.rest.serv.ayispringrestful.service;

import com.ayi.curso.rest.serv.ayispringrestful.entity.Users;

import java.util.List;

public interface UserService {
	// Get all
    List<Users> fetchUserList();
    
	// Create
    Users saveUser(Users user);
 
    // Update
    Users updateUser(Users user, Long id);
 
    // Delete
    void deleteUsertById(Long id);
    
    //Search by name
    List<Users> searchByName(String name);

}
