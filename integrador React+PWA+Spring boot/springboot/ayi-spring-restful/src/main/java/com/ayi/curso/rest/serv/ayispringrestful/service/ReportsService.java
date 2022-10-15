package com.ayi.curso.rest.serv.ayispringrestful.service;

import com.ayi.curso.rest.serv.ayispringrestful.dto.response.LendingDTOResponse;
import com.ayi.curso.rest.serv.ayispringrestful.exceptions.InternalException;
import com.ayi.curso.rest.serv.ayispringrestful.exceptions.NotFoundException;

import java.util.List;

public interface ReportsService {
	
	//Get all
    List<LendingDTOResponse> getAllReports()
            throws NotFoundException, InternalException;
	
	//Download reports in excel or pdf

}
