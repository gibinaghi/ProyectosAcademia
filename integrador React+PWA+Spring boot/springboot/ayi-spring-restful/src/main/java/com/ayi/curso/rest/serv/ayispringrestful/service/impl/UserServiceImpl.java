package com.ayi.curso.rest.serv.ayispringrestful.service.impl;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.ayi.curso.rest.serv.ayispringrestful.dto.request.UserCreateDTORequest;
import com.ayi.curso.rest.serv.ayispringrestful.dto.response.UserDTOResponse;
import com.ayi.curso.rest.serv.ayispringrestful.entity.Users;
import com.ayi.curso.rest.serv.ayispringrestful.exceptions.BadRequestException;
import com.ayi.curso.rest.serv.ayispringrestful.exceptions.InternalException;
import com.ayi.curso.rest.serv.ayispringrestful.exceptions.NotFoundException;
import com.ayi.curso.rest.serv.ayispringrestful.mapper.IUsersMapper;
import com.ayi.curso.rest.serv.ayispringrestful.repository.UsersRepository;
import com.ayi.curso.rest.serv.ayispringrestful.service.UserService;
import lombok.AllArgsConstructor;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

import static com.ayi.curso.rest.serv.ayispringrestful.constants.Exceptions.*;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    // Repository
    private UsersRepository usersRepository;

    // Mapper
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
    {
        Users userEntity = usersMapper.convertDtoToEntityCreate(userRequest);

        //validar que si el dni existe tire excepcion

        //Save
        userEntity = usersRepository.save(userEntity);

        return usersMapper.convertEntityToDto(userEntity);
    }

    // Update  --> faltan las excepciones
    /*@Override
    @Transactional
    public Users updateUser(Users user, Long id)
    {
        Users usDB = usersRepository.findById(id).get();
 
        if (Objects.nonNull(user.getName()) && !"".equalsIgnoreCase(user.getName())) {
            usDB.setName(user.getName());
        }
        
        if (Objects.nonNull(user.getLast_name_p()) && !"".equalsIgnoreCase(user.getLast_name_p())) {
            usDB.setLast_name_p(user.getLast_name_p());
        }
        
        if (Objects.nonNull(user.getLast_name_m()) && !"".equalsIgnoreCase(user.getLast_name_m())) {
            usDB.setLast_name_m(user.getLast_name_m());
        }
        
        if (Objects.nonNull(user.getDomicilio()) && !"".equalsIgnoreCase(user.getDomicilio())) {
            usDB.setDomicilio(user.getDomicilio());
        }
        
        if (Objects.nonNull(user.getTel()) && !"".equalsIgnoreCase(user.getTel())) {
            usDB.setTel(user.getTel());
        }
        
        if (Objects.nonNull(user.getSanctions())) {
            usDB.setSanctions(user.getSanctions());
        }
        
        if (Objects.nonNull(user.getSanc_money())) {
            usDB.setSanc_money(user.getSanc_money());
        }

        return usersRepository.save(usDB);
    }*/
 
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

    //Search by name --> faltan las excepciones
    @Override
    @Transactional
    public List<Users> searchByName(String name)
    {
        return (List<Users>) usersRepository.findByName(name);
    }

}
