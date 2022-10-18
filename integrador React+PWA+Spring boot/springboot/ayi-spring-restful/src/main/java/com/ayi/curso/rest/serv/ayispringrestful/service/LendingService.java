package com.ayi.curso.rest.serv.ayispringrestful.service;


import com.ayi.curso.rest.serv.ayispringrestful.dto.request.LendingCreateDTORequest;
import com.ayi.curso.rest.serv.ayispringrestful.dto.response.LendingDTOResponse;
import com.ayi.curso.rest.serv.ayispringrestful.exceptions.BadRequestException;
import com.ayi.curso.rest.serv.ayispringrestful.exceptions.NotFoundException;

public interface LendingService {
    
	// Create
    LendingDTOResponse createLending(LendingCreateDTORequest lending, Long userId, Long bookId)
            throws BadRequestException, NotFoundException;
}
