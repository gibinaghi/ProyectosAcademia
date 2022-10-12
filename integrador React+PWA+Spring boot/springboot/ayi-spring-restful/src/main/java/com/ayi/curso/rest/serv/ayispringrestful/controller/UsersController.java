package com.ayi.curso.rest.serv.ayispringrestful.controller;

import com.ayi.curso.rest.serv.ayispringrestful.dto.request.UserCreateDTORequest;
import com.ayi.curso.rest.serv.ayispringrestful.dto.response.BookDTOResponse;
import com.ayi.curso.rest.serv.ayispringrestful.dto.response.UserDTOResponse;
import com.ayi.curso.rest.serv.ayispringrestful.entity.Users;
import com.ayi.curso.rest.serv.ayispringrestful.exceptions.BadRequestException;
import com.ayi.curso.rest.serv.ayispringrestful.exceptions.InternalException;
import com.ayi.curso.rest.serv.ayispringrestful.exceptions.NotFoundException;
import com.ayi.curso.rest.serv.ayispringrestful.service.UserService;
import io.swagger.annotations.*;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
            @ApiResponse(code = 404, message = "Users not found"),
    })
    public ResponseEntity<?> fetchUserList() throws NotFoundException, InternalException
    {
        List<UserDTOResponse> userResponse = usersService.fetchUserList();
        return ResponseEntity.ok(userResponse );
    }
    
    // Create
    @PostMapping(
            value = "/user",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(
            value = "Create user",
            httpMethod = "POST",
            response = UserDTOResponse.class
    )
    @ApiResponses(value = {
            @ApiResponse(code = 201,
                    message = "Body content with all information about address",
                    response = UserDTOResponse.class),
            @ApiResponse(code = 400,
                    message = "Describes errors on invalid payload received, e.g: missing fields, invalid data form")
    })
    public ResponseEntity<UserDTOResponse> createUser(
            @ApiParam(value = "data of user", required = true)
            @RequestBody UserCreateDTORequest request
    ) {
        UserDTOResponse userResponse = usersService.createUser(request);
        return new ResponseEntity<>(userResponse, HttpStatus.CREATED);
    }

    // Update  --> faltan las excepciones
    @PatchMapping("/user/{id}")
    public Users updateUser(
    		@RequestBody Users user,
            @PathVariable("id") Long id)
    {
        return usersService.updateUser(user, id);
    }
 
    // Delete
    @DeleteMapping("/user/{id}")
    @ApiOperation(
            value = "Delete a user by id",
            httpMethod = "DELETE"
    )
    @ApiResponses(value = {
            @ApiResponse(code = 204, message = "Success. User deleted by id"),
            @ApiResponse(code = 404, message = "User not found"),
            @ApiResponse(code = 400 , message = "Bad request/Invalid field")})
    public ResponseEntity<Void> deleteUser(
            @ApiParam(name = "id", required = true, value = "User Id", example = "1")
            @PathVariable Long id
    ) throws BadRequestException, NotFoundException, InternalException {
        usersService.deleteUser(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
    
    // Search by name --> faltan las excepciones
    @GetMapping("/users/{name}")
    public List<Users> searchByName(@PathVariable("name") String name)
    {
        return usersService.searchByName(name);
    }
}
