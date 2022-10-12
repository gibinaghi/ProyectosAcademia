package com.ayi.curso.rest.serv.ayispringrestful.mapper.impl;

import com.ayi.curso.rest.serv.ayispringrestful.dto.request.UserCreateDTORequest;
import com.ayi.curso.rest.serv.ayispringrestful.dto.response.UserDTOResponse;
import com.ayi.curso.rest.serv.ayispringrestful.entity.Users;
import com.ayi.curso.rest.serv.ayispringrestful.mapper.IUsersMapper;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class UsersMapperImp implements IUsersMapper {
    private final ModelMapper modelMapper;

    @Override
    public Users convertDtoToEntity(UserDTOResponse request) {

        return modelMapper.map(request, Users.class);
    }

    @Override
    public UserDTOResponse convertEntityToDto(Users entity) {

        return modelMapper.map(entity, UserDTOResponse.class);
    }

    @Override
    public Users convertDtoToEntityCreate(UserCreateDTORequest request) {

        return modelMapper.map(request, Users.class);
    }
}
