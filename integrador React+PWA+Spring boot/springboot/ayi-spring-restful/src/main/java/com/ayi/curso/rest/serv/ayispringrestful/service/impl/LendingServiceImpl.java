package com.ayi.curso.rest.serv.ayispringrestful.service.impl;

import java.util.List;
import java.util.Objects;

import com.ayi.curso.rest.serv.ayispringrestful.entity.Books;
import com.ayi.curso.rest.serv.ayispringrestful.entity.Lendings;
import com.ayi.curso.rest.serv.ayispringrestful.entity.Users;
import com.ayi.curso.rest.serv.ayispringrestful.repository.BooksRepository;
import com.ayi.curso.rest.serv.ayispringrestful.repository.LendingsRepository;
import com.ayi.curso.rest.serv.ayispringrestful.repository.UsersRepository;
import com.ayi.curso.rest.serv.ayispringrestful.service.LendingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class LendingServiceImpl implements LendingService {
	@Autowired
    private LendingsRepository lendingsRepository;
	private UsersRepository userRepository;
	private BooksRepository bookRepository;
 
	// Get all
    @Override 
    public List<Lendings> fetchLendingList()
    {
        return (List<Lendings>) lendingsRepository.findAll();
    }
    
    
    //Create
    @Override
    public Lendings createLending(Lendings lending, Long userId, Long bookId)
    {
  
    	Users user = userRepository.findById(userId).get();
    	
    	Books book =bookRepository.findById(bookId).get();
    	
    	
    	Lendings lend = new Lendings();
    	lend.setDate_out(lending.getDate_out());
    	lend.setDate_return(lending.getDate_return());
    	lend.setUsers(user);
    	lend.setBooks(book);
    	
    	return lendingsRepository.save(lend);
    }
    
    
    // Create ---creo q no va
   @Override
    public Lendings saveLending(Lendings lending)
    {
        return lendingsRepository.save(lending);
    }
    
    // Update
    @Override
    public Lendings updateLending(Lendings lending, Long id)
    {
        Lendings lendDB = lendingsRepository.findById(id).get();
 
        if (Objects.nonNull(lending.getBooks_id()) && !"".equalsIgnoreCase(lending.getBooks_id())) {
        	lendDB.setBooks_id(lending.getBooks_id());
        }
        if (Objects.nonNull(lending.getUsers_id()) && !"".equalsIgnoreCase(lending.getUsers_id())) {
        	lendDB.setUsers_id(lending.getUsers_id());
        }
        if (Objects.nonNull(lending.getDate_out()) && !"".equalsIgnoreCase(lending.getDate_out())) {
        	lendDB.setDate_out(lending.getDate_out());
        }
        if (Objects.nonNull(lending.getDate_return()) && !"".equalsIgnoreCase(lending.getDate_return())) {
        	lendDB.setDate_return(lending.getDate_return());
        }
        
 
        return lendingsRepository.save(lendDB);
    }
    
    // Delete
    @Override
    public void deleteLendingById(Long id)
    {
        lendingsRepository.deleteById(id);
    }

}
