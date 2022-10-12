package com.ayi.curso.rest.serv.ayispringrestful.controller;

import com.ayi.curso.rest.serv.ayispringrestful.dto.response.BookDTOResponse;
import com.ayi.curso.rest.serv.ayispringrestful.dto.response.UserDTOResponse;
import com.ayi.curso.rest.serv.ayispringrestful.entity.Users;
import com.ayi.curso.rest.serv.ayispringrestful.exceptions.InternalException;
import com.ayi.curso.rest.serv.ayispringrestful.exceptions.NotFoundException;
import com.ayi.curso.rest.serv.ayispringrestful.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
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

@Api(value = "Address Api", tags = {"Address Service"})
@CrossOrigin(origins = "http://localhost:3306")
@RequestMapping(value = "/api", produces = {MediaType.APPLICATION_JSON_VALUE})
@AllArgsConstructor
@RestController
public class UsersController {
	
	@Autowired
	private UserService usersService;
	
	// Get all 
    @GetMapping("/users")
    @ApiOperation(
            value = "List all users",
            httpMethod = "GET",
            response = UserDTOResponse[].class
    )
    @ApiResponses(value = {
            @ApiResponse(
                    code = 200,
                    message = "Shows the list of users",
                    response = UserDTOResponse[].class
            ),
            @ApiResponse(code = 404, message = "Detail address not found"),
    })
    public ResponseEntity<?> fetchUserList() throws NotFoundException, InternalException
    {
        List<UserDTOResponse> userResponse = usersService.fetchUserList();
        return ResponseEntity.ok(userResponse );
    }
    
    // Create
    @PostMapping("/user")
    public Users saveUser(@RequestBody Users user)
    {
        return usersService.saveUser(user);
    }
    
    // Update
    @PatchMapping("/user/{id}")
    public Users updateUser(
    		@RequestBody Users user,
            @PathVariable("id") Long id)
    {
        return usersService.updateUser(user, id);
    }
 
    // Delete
    @DeleteMapping("/user/{id}")
    public String deleteUserById(@PathVariable("id") Long id)
    {
    	try {
    	usersService.deleteUsertById(id);
        return "Deleted Successfully";
    	}catch(Exception e){
    		return "ERROR: No deleted";
    	}
    }
    
    // Search by name 
    @GetMapping("/users/{name}")
    public List<Users> searchByName(@PathVariable("name") String name)
    {
        return usersService.searchByName(name);
    }
}
