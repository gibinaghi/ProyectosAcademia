package com.ayi.curso.rest.serv.ayispringrestful.service;


import com.ayi.curso.rest.serv.ayispringrestful.dto.request.LendingCreateDTORequest;
import com.ayi.curso.rest.serv.ayispringrestful.dto.response.LendingDTOResponse;
import com.ayi.curso.rest.serv.ayispringrestful.entity.Lendings;

import java.util.List;

public interface LendingService {
	// Get all -> no necesito?
    List<Lendings> fetchLendingList();
    
	// Create
    LendingDTOResponse createLending(LendingCreateDTORequest lending, Long userId, Long bookId);
 
    // Delete -> no necesito?
    void deleteLendingById(Long id);
}
