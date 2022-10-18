package com.ayi.curso.rest.serv.ayispringrestful.service.impl;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import com.ayi.curso.rest.serv.ayispringrestful.dto.request.UserCreateDTORequest;
import com.ayi.curso.rest.serv.ayispringrestful.dto.request.UserUpdateDTORequest;
import com.ayi.curso.rest.serv.ayispringrestful.dto.response.UserDTOResponse;
import com.ayi.curso.rest.serv.ayispringrestful.entity.Users;
import com.ayi.curso.rest.serv.ayispringrestful.exceptions.BadRequestException;
import com.ayi.curso.rest.serv.ayispringrestful.exceptions.InternalException;
import com.ayi.curso.rest.serv.ayispringrestful.exceptions.NotFoundException;
import com.ayi.curso.rest.serv.ayispringrestful.mapper.IUsersMapper;
import com.ayi.curso.rest.serv.ayispringrestful.repository.UsersRepository;
import com.ayi.curso.rest.serv.ayispringrestful.service.UserService;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

import static com.ayi.curso.rest.serv.ayispringrestful.constants.Exceptions.*;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    // Repository
    @NotNull
    private UsersRepository usersRepository;

    // Mapper
    @NotNull
    private IUsersMapper usersMapper;
 
	// Get all
    @Override
    @Transactional
    public List<UserDTOResponse> fetchUserList()
            throws NotFoundException, InternalException
    {
        List<Users> entityList = null;
        try {
            entityList = usersRepository.findAll();
        } catch (Exception ex) {
            throw new InternalException(INTERNAL, ex);
        }

        if(CollectionUtils.isEmpty(entityList)) {
            throw new NotFoundException(EXCEPTION_DATA_NULL);
        }

        List<UserDTOResponse> listResponse = new ArrayList<>();
        entityList.forEach(user -> {
            UserDTOResponse userResponse = usersMapper.convertEntityToDto(user);
            listResponse.add(userResponse);
        });

        return listResponse ;
    }
    
    // Create
    @Override
    @Transactional
    public UserDTOResponse createUser(UserCreateDTORequest userRequest)
            throws BadRequestException
    {

        Users userEntity = usersMapper.convertDtoToEntityCreate(userRequest);

        if(
                userEntity.getName().isEmpty() || userEntity.getLast_name().isEmpty() ||
                        userEntity.getDni().isEmpty() || userEntity.getAddress().isEmpty() ||
                        userEntity.getPhone().isEmpty()
        ){
            throw new BadRequestException(EXCEPTION_FIEL_REQ);
        }

        //Save
        userEntity = usersRepository.save(userEntity);

        return usersMapper.convertEntityToDto(userEntity);
    }

    // Update
    @Override
    @Transactional
    public UserDTOResponse updateUser(UserUpdateDTORequest userUpdateDTORequest, Long id)
            throws BadRequestException
    {
        if(id == null || id < 0){
            throw new BadRequestException(EXCEPTION_ID_NOT_VALID);
        }

        Users user = usersMapper.convertDtoToEntityUpdate(userUpdateDTORequest);

        Users usDB = usersRepository.findById(id).get();
 
        if (Objects.nonNull(user.getName()) && !"".equalsIgnoreCase(user.getName())) {
            usDB.setName(user.getName());
        }
        
        if (Objects.nonNull(user.getLast_name()) && !"".equalsIgnoreCase(user.getLast_name())) {
            usDB.setLast_name(user.getLast_name());
        }
        
        if (Objects.nonNull(user.getDni()) && !"".equalsIgnoreCase(user.getDni())) {
            usDB.setDni(user.getDni());
        }
        
        if (Objects.nonNull(user.getAddress()) && !"".equalsIgnoreCase(user.getAddress())) {
            usDB.setAddress(user.getAddress());
        }
        
        if (Objects.nonNull(user.getPhone()) && !"".equalsIgnoreCase(user.getPhone())) {
            usDB.setPhone(user.getPhone());
        }

        usDB = usersRepository.save(usDB);

        return usersMapper.convertEntityToDto(usDB);
    }
 
    // Delete
    @Override
    public void deleteUser(Long idUser)
            throws BadRequestException, InternalException, NotFoundException {

        if(idUser == null || idUser < 0){
            throw new BadRequestException(EXCEPTION_ID_NOT_VALID);
        }

        Optional<Users> entity = null;
        try {
            entity = usersRepository.findById(idUser);
        } catch (Exception ex) {
            throw new InternalException(INTERNAL, ex);
        }

        if (entity.isPresent()) {
            usersRepository.deleteById(idUser);
        } else {
            throw new NotFoundException(EXCEPTION_ID_NULL);
        }
    }

    //Search by name
    @Override
    @Transactional
    public List<UserDTOResponse> searchByName(String name)
            throws NotFoundException
    {
        List<Users> listUsers = usersRepository.findByName(name);

        if(listUsers.isEmpty()){
            throw new NotFoundException(EXCEPTION_DATA_NULL);
        }

        List<UserDTOResponse> listResponse = new ArrayList<>();
        listUsers.forEach(user -> {
            UserDTOResponse userResponse = usersMapper.convertEntityToDto(user);
            listResponse.add(userResponse);
        });

        return listResponse ;
    }

}
