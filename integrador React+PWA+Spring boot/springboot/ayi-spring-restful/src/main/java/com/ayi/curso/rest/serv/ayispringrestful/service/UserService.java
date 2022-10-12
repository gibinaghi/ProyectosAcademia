package com.ayi.curso.rest.serv.ayispringrestful.service;

import com.ayi.curso.rest.serv.ayispringrestful.dto.request.UserCreateDTORequest;
import com.ayi.curso.rest.serv.ayispringrestful.dto.response.UserDTOResponse;
import com.ayi.curso.rest.serv.ayispringrestful.entity.Users;
import com.ayi.curso.rest.serv.ayispringrestful.exceptions.BadRequestException;
import com.ayi.curso.rest.serv.ayispringrestful.exceptions.InternalException;
import com.ayi.curso.rest.serv.ayispringrestful.exceptions.NotFoundException;

import java.util.List;

public interface UserService {
	// Get all
    List<UserDTOResponse> fetchUserList()
            throws NotFoundException, InternalException;
    
	// Create
    UserDTOResponse createUser(UserCreateDTORequest userRequest);
 
    // Update --> faltan las excepciones
    Users updateUser(Users user, Long id);
 
    // Delete
    void deleteUser(Long idUser)
            throws BadRequestException, InternalException, NotFoundException;
    
    //Search by name --> faltan las excepciones
    List<Users> searchByName(String name);

}
