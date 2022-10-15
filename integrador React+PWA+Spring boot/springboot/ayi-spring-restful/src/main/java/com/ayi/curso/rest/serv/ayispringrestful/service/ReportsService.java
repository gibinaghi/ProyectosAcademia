package com.ayi.curso.rest.serv.ayispringrestful.service;

import com.ayi.curso.rest.serv.ayispringrestful.dto.response.LendingDTOResponse;
import com.ayi.curso.rest.serv.ayispringrestful.entity.Lendings;
import com.ayi.curso.rest.serv.ayispringrestful.exceptions.InternalException;
import com.ayi.curso.rest.serv.ayispringrestful.exceptions.NotFoundException;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;

public interface ReportsService {
	
	//Get all
    List<LendingDTOResponse> getAllReports()
            throws NotFoundException, InternalException;
	
	//Download reports in excel or pdf
    ByteArrayInputStream load();

}
