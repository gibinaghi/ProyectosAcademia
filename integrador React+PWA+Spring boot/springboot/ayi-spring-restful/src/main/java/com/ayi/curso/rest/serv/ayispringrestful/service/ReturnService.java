package com.ayi.curso.rest.serv.ayispringrestful.service;

import com.ayi.curso.rest.serv.ayispringrestful.exceptions.BadRequestException;
import com.ayi.curso.rest.serv.ayispringrestful.exceptions.InternalException;
import com.ayi.curso.rest.serv.ayispringrestful.exceptions.NotFoundException;

public interface ReturnService {
	
	//Delete lending
    void deleteLendingById(Long id) throws BadRequestException, InternalException, NotFoundException;

}
