package com.ayi.curso.rest.serv.ayispringrestful.service.impl;
import java.util.List;
import java.util.Objects;

import com.ayi.curso.rest.serv.ayispringrestful.entity.Users;
import com.ayi.curso.rest.serv.ayispringrestful.repository.UsersRepository;
import com.ayi.curso.rest.serv.ayispringrestful.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
    private UsersRepository usersRepository;
 
	// Get all
    @Override 
    public List<Users> fetchUserList()
    {
        return (List<Users>) usersRepository.findAll();
    }
    
    // Create
    @Override
    public Users saveUser(Users user)
    {
        return usersRepository.save(user);
    }
 
    // Update
    @Override
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
    }
 
    // Delete
    @Override
    public void deleteUsertById(Long id)
    {
    	usersRepository.deleteById(id);
    }
    
    //Search by name
    @Override
    public List<Users> searchByName(String name)
    {
    	return (List<Users>) usersRepository.findByName(name);
    }

}
