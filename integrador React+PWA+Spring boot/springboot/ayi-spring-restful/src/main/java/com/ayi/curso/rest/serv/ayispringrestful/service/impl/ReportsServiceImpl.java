package com.ayi.curso.rest.serv.ayispringrestful.service.impl;

import com.ayi.curso.rest.serv.ayispringrestful.dto.response.LendingDTOResponse;
import com.ayi.curso.rest.serv.ayispringrestful.entity.Lendings;
import com.ayi.curso.rest.serv.ayispringrestful.exceptions.InternalException;
import com.ayi.curso.rest.serv.ayispringrestful.exceptions.NotFoundException;
import com.ayi.curso.rest.serv.ayispringrestful.mapper.ILendingsMapper;
import com.ayi.curso.rest.serv.ayispringrestful.repository.LendingsRepository;
import com.ayi.curso.rest.serv.ayispringrestful.service.ReportsService;
import com.ayi.curso.rest.serv.ayispringrestful.utils.ExcelHelper;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.List;

import static com.ayi.curso.rest.serv.ayispringrestful.constants.Exceptions.EXCEPTION_DATA_NULL;
import static com.ayi.curso.rest.serv.ayispringrestful.constants.Exceptions.INTERNAL;

@Service
@RequiredArgsConstructor
public class ReportsServiceImpl implements ReportsService {

    // Repository
    @NotNull
    private LendingsRepository lendingsRepository;

    // Mapper
    @NotNull
    private ILendingsMapper lendingsMapper;

    // Get all
    @Override
    @Transactional
    public List<LendingDTOResponse> getAllReports()
            throws NotFoundException, InternalException
    {
        List<Lendings> entityList = null;
        try {
            entityList = lendingsRepository.findAll();
        } catch (Exception ex) {
            throw new InternalException(INTERNAL, ex);
        }

        if(CollectionUtils.isEmpty(entityList)) {
            throw new NotFoundException(EXCEPTION_DATA_NULL);
        }

        List<LendingDTOResponse> listResponse = new ArrayList<>();
        entityList.forEach(lend -> {
            LendingDTOResponse lendResponse = lendingsMapper.convertEntityToDto(lend);
            listResponse.add(lendResponse);
        });

        return listResponse ;
    }

    // Excel
    public ByteArrayInputStream load() {
        List<Lendings> lendings = lendingsRepository.findAll();

        ByteArrayInputStream in = ExcelHelper.tutorialsToExcel(lendings);
        return in;
    }
}
