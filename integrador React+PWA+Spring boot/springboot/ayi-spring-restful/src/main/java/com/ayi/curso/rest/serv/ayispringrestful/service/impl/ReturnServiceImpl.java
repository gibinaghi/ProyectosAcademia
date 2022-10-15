package com.ayi.curso.rest.serv.ayispringrestful.service.impl;

import com.ayi.curso.rest.serv.ayispringrestful.repository.LendingsRepository;
import com.ayi.curso.rest.serv.ayispringrestful.service.ReturnService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ReturnServiceImpl implements ReturnService {

    // Repository
    private LendingsRepository lendingsRepository;

    //Delete lending
    @Override
    public void deleteLendingById(Long id)
    {
        lendingsRepository.deleteById(id);
    }

}
