package com.ayi.curso.rest.serv.ayispringrestful.service.impl;

import com.ayi.curso.rest.serv.ayispringrestful.dto.request.LendingCreateDTORequest;
import com.ayi.curso.rest.serv.ayispringrestful.dto.response.LendingDTOResponse;
import com.ayi.curso.rest.serv.ayispringrestful.entity.Books;
import com.ayi.curso.rest.serv.ayispringrestful.entity.Lendings;
import com.ayi.curso.rest.serv.ayispringrestful.entity.Users;
import com.ayi.curso.rest.serv.ayispringrestful.exceptions.BadRequestException;
import com.ayi.curso.rest.serv.ayispringrestful.exceptions.NotFoundException;
import com.ayi.curso.rest.serv.ayispringrestful.mapper.ILendingsMapper;
import com.ayi.curso.rest.serv.ayispringrestful.repository.BooksRepository;
import com.ayi.curso.rest.serv.ayispringrestful.repository.LendingsRepository;
import com.ayi.curso.rest.serv.ayispringrestful.repository.UsersRepository;
import com.ayi.curso.rest.serv.ayispringrestful.service.LendingService;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

import static com.ayi.curso.rest.serv.ayispringrestful.constants.Exceptions.EXCEPTION_DATA_NULL;
import static com.ayi.curso.rest.serv.ayispringrestful.constants.Exceptions.EXCEPTION_ID_NOT_VALID;


@Service
@RequiredArgsConstructor
public class LendingServiceImpl implements LendingService {

    // Repository
    @NotNull
    private LendingsRepository lendingsRepository;
    @NotNull
	private UsersRepository userRepository;
    @NotNull
	private BooksRepository bookRepository;

    // Mapper
    @NotNull
    private ILendingsMapper lendingsMapper;

    
    // Create
    @Override
    public LendingDTOResponse createLending(LendingCreateDTORequest lending, Long userId, Long bookId)
        throws BadRequestException, NotFoundException
    {
        if(userId == null || userId < 0){
            throw new BadRequestException(EXCEPTION_ID_NOT_VALID);
        }

        if(bookId == null || bookId < 0){
            throw new BadRequestException(EXCEPTION_ID_NOT_VALID);
        }

        // Mapper lending -> Lending entity
        Lendings lendEntity = lendingsMapper.convertDtoToEntity(lending);

        // Find user with userId
        Optional<Users> userEntity = userRepository.findById(userId);
        // Find book with bookId
        Optional<Books> bookEntity =bookRepository.findById(bookId);

        if(!bookEntity.isPresent() ||
                !bookEntity.isPresent()) {
            throw new NotFoundException(EXCEPTION_DATA_NULL);
        }

        // Set user and book entity en lending entity
        lendEntity.setUsers(userEntity.get());
        lendEntity.setBooks(bookEntity.get());

        // Save
        lendEntity = lendingsRepository.save(lendEntity);
    	
    	return lendingsMapper.convertEntityToDto(lendEntity);
    }


}
