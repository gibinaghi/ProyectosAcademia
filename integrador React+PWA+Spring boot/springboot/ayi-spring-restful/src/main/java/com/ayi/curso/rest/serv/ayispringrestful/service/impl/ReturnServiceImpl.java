package com.ayi.curso.rest.serv.ayispringrestful.constants.service.impl;

import com.ayi.curso.rest.serv.ayispringrestful.entity.Lendings;
import com.ayi.curso.rest.serv.ayispringrestful.exceptions.BadRequestException;
import com.ayi.curso.rest.serv.ayispringrestful.exceptions.InternalException;
import com.ayi.curso.rest.serv.ayispringrestful.exceptions.NotFoundException;
import com.ayi.curso.rest.serv.ayispringrestful.repository.LendingsRepository;
import com.ayi.curso.rest.serv.ayispringrestful.constants.service.ReturnService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static com.ayi.curso.rest.serv.ayispringrestful.constants.Exceptions.*;

@Service
@AllArgsConstructor
public class ReturnServiceImpl implements ReturnService {

    // Repository
    private LendingsRepository lendingsRepository;

    //Delete lending
    @Override
    public void deleteLendingById(Long id)
            throws BadRequestException, InternalException, NotFoundException {

        if(id == null || id < 0){
            throw new BadRequestException(EXCEPTION_ID_NOT_VALID);
        }

        Optional<Lendings> entity = null;
        try {
            entity = lendingsRepository.findById(id);
        } catch (Exception ex) {
            throw new InternalException(INTERNAL, ex);
        }

        if (entity.isPresent()) {
            lendingsRepository.deleteById(id);
        } else {
            throw new NotFoundException(EXCEPTION_ID_NULL);
        }
    }

}
