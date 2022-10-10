package com.ayi.curso.rest.serv.ayispringrestful.controller;

import com.ayi.curso.rest.serv.ayispringrestful.entity.Lendings;
import com.ayi.curso.rest.serv.ayispringrestful.service.LendingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@CrossOrigin(origins = "http://localhost:3306")
@RestController
@RequestMapping("/api")
public class LendingsController {
	@Autowired
	private LendingService lendingService;
	
	// Get all 
    @GetMapping("/lending")
    public List<Lendings> fetchLendingList()
    {
        return lendingService.fetchLendingList();
    }
    
	// Create
    @PostMapping("/createlending")
    public Lendings createLending(@RequestBody Lendings lending, Long userId, Long bookId)
    {
        return lendingService.saveLending(lending);
    }
    @PostMapping("/lending")
    public Lendings saveLending(@RequestBody Lendings lending)
    {
        return lendingService.saveLending(lending);
    }
    
    // Update
    @PatchMapping("/lending/{id}")
    public Lendings updateLending(
    		@RequestBody Lendings lending,
            @PathVariable("id") Long id)
    {
        return lendingService.updateLending(lending, id);
    }
    
    // Delete
    @DeleteMapping("/lending/{id}")
    public String deleteLendingById(@PathVariable("id") Long id)
    {
    	try {
    	lendingService.deleteLendingById(id);
        return "Deleted Successfully";
    	}catch(Exception e){
    		return "ERROR: No deleted";
    	}
    }

}
