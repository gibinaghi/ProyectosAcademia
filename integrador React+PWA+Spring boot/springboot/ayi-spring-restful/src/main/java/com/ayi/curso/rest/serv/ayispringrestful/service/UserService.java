package com.ayi.curso.rest.serv.ayispringrestful.service;

import com.ayi.curso.rest.serv.ayispringrestful.dto.response.UserDTOResponse;
import com.ayi.curso.rest.serv.ayispringrestful.entity.Users;
import com.ayi.curso.rest.serv.ayispringrestful.exceptions.InternalException;
import com.ayi.curso.rest.serv.ayispringrestful.exceptions.NotFoundException;

import java.util.List;

public interface UserService {
	// Get all
    List<UserDTOResponse> fetchUserList()
            throws NotFoundException, InternalException;
    
	// Create
    Users saveUser(Users user);
 
    // Update
    Users updateUser(Users user, Long id);
 
    // Delete
    void deleteUsertById(Long id);
    
    //Search by name
    List<Users> searchByName(String name);

}
