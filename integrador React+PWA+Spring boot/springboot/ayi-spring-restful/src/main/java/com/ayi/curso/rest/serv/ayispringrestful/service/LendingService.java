package com.ayi.curso.rest.serv.ayispringrestful.service;


import com.ayi.curso.rest.serv.ayispringrestful.dto.request.LendingCreateDTORequest;
import com.ayi.curso.rest.serv.ayispringrestful.dto.response.LendingDTOResponse;

public interface LendingService {
    
	// Create
    LendingDTOResponse createLending(LendingCreateDTORequest lending, Long userId, Long bookId);
}
