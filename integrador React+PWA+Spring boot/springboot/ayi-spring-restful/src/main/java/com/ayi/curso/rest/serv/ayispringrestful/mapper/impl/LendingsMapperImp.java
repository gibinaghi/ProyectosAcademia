package com.ayi.curso.rest.serv.ayispringrestful.mapper.impl;

import com.ayi.curso.rest.serv.ayispringrestful.dto.request.LendingCreateDTORequest;
import com.ayi.curso.rest.serv.ayispringrestful.dto.response.LendingDTOResponse;
import com.ayi.curso.rest.serv.ayispringrestful.entity.Lendings;
import com.ayi.curso.rest.serv.ayispringrestful.mapper.ILendingsMapper;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class LendingsMapperImp implements ILendingsMapper {

    private final ModelMapper modelMapper;

    @Override
    public Lendings convertDtoToEntity(LendingCreateDTORequest request) {

        return modelMapper.map(request, Lendings.class);
    }

    @Override
    public LendingDTOResponse convertEntityToDto(Lendings entity){

        return modelMapper.map(entity, LendingDTOResponse.class);
    }
}
