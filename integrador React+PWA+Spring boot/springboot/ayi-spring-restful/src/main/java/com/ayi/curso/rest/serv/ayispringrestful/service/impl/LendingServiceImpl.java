package com.ayi.curso.rest.serv.ayispringrestful.service.impl;

import com.ayi.curso.rest.serv.ayispringrestful.dto.request.LendingCreateDTORequest;
import com.ayi.curso.rest.serv.ayispringrestful.dto.response.LendingDTOResponse;
import com.ayi.curso.rest.serv.ayispringrestful.entity.Books;
import com.ayi.curso.rest.serv.ayispringrestful.entity.Lendings;
import com.ayi.curso.rest.serv.ayispringrestful.entity.Users;
import com.ayi.curso.rest.serv.ayispringrestful.mapper.ILendingsMapper;
import com.ayi.curso.rest.serv.ayispringrestful.repository.BooksRepository;
import com.ayi.curso.rest.serv.ayispringrestful.repository.LendingsRepository;
import com.ayi.curso.rest.serv.ayispringrestful.repository.UsersRepository;
import com.ayi.curso.rest.serv.ayispringrestful.service.LendingService;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


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
    {
        // Mapper lending -> Lending entity
        Lendings lendEntity = lendingsMapper.convertDtoToEntity(lending);

        // Find user with userId
    	Users userEntity = userRepository.findById(userId).get();
        // Find book with bookId
    	Books bookEntity =bookRepository.findById(bookId).get();

        // Set user and book entity en lending entity
        lendEntity.setUsers(userEntity);
        lendEntity.setBooks(bookEntity);

        // Save
        lendEntity = lendingsRepository.save(lendEntity);
    	
    	return lendingsMapper.convertEntityToDto(lendEntity);
    }


}
