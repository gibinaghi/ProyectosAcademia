package com.ayi.curso.rest.serv.ayispringrestful.service;

import com.ayi.curso.rest.serv.ayispringrestful.dto.request.UserCreateDTORequest;
import com.ayi.curso.rest.serv.ayispringrestful.dto.request.UserUpdateDTORequest;
import com.ayi.curso.rest.serv.ayispringrestful.dto.response.UserDTOResponse;
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
 
    // Update
    UserDTOResponse updateUser(UserUpdateDTORequest userUpdateDTORequest, Long id)
            throws BadRequestException;
 
    // Delete
    void deleteUser(Long idUser)
            throws BadRequestException, InternalException, NotFoundException;
    
    //Search by name
    List<UserDTOResponse> searchByName(String name);

}
