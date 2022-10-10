package com.ayi.curso.rest.serv.ayispringrestful.service;


import com.ayi.curso.rest.serv.ayispringrestful.entity.Lendings;

import java.util.List;

public interface LendingService {
	// Get all -> no necesito?
    List<Lendings> fetchLendingList();
    
	// Create
    Lendings saveLending(Lendings lending);
    Lendings createLending(Lendings lending, Long userId, Long bookId);
 
    // Update -> no necesito?
    Lendings updateLending(Lendings lending, Long id);
 
    // Delete -> no necesito?
    void deleteLendingById(Long id);
}
