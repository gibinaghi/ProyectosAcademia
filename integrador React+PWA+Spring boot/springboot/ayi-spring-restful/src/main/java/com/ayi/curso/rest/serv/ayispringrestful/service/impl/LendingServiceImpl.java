package com.ayi.curso.rest.serv.ayispringrestful.service.impl;

import java.util.List;

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
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class LendingServiceImpl implements LendingService {

    // Repository
    private LendingsRepository lendingsRepository;
	private UsersRepository userRepository;
	private BooksRepository bookRepository;

    // Mapper
    private ILendingsMapper lendingsMapper;
 
	// Get all
    @Override 
    public List<Lendings> fetchLendingList()
    {
        return (List<Lendings>) lendingsRepository.findAll();
    }
    
    
    // Create
    @Override
    public LendingDTOResponse createLending(LendingCreateDTORequest lending, Long userId, Long bookId)
    {
        // Mapper lending -> Lending entity
        Lendings lendEntity = lendingsMapper.convertDtoToEntity(lending);

        // Me fijo si hay cantidad de libros para prestar, si -> descuento uno

        // Find user with userId
    	Users userEntity = userRepository.findById(userId).get();
        // Find book with bookId
    	Books bookEntity =bookRepository.findById(bookId).get();

        // Set user and book entity en lending entity
        lendEntity.setUsers(userEntity);
        lendEntity.setBooks(bookEntity);

        // Set date_return in lending entity -> ver como hacer, tipo Date
        //lendEntity.setDate_return(lending.getDate_out() + 15);

        // Save
        lendEntity = lendingsRepository.save(lendEntity);
    	
    	return lendingsMapper.convertEntityToDto(lendEntity);
    }
    
    // Delete
    @Override
    public void deleteLendingById(Long id)
    {
        lendingsRepository.deleteById(id);
    }

}
