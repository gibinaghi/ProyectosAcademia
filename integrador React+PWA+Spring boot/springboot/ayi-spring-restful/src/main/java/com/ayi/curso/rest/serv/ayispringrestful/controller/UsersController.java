package com.ayi.curso.rest.serv.ayispringrestful.controller;

import com.ayi.curso.rest.serv.ayispringrestful.dto.request.UserCreateDTORequest;
import com.ayi.curso.rest.serv.ayispringrestful.dto.request.UserUpdateDTORequest;
import com.ayi.curso.rest.serv.ayispringrestful.dto.response.UserDTOResponse;
import com.ayi.curso.rest.serv.ayispringrestful.exceptions.BadRequestException;
import com.ayi.curso.rest.serv.ayispringrestful.exceptions.InternalException;
import com.ayi.curso.rest.serv.ayispringrestful.exceptions.NotFoundException;
import com.ayi.curso.rest.serv.ayispringrestful.service.UserService;
import io.swagger.annotations.*;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Api(value = "User Api", tags = {"User Service"})
@RequestMapping(value = "/api", produces = {MediaType.APPLICATION_JSON_VALUE})
@AllArgsConstructor
@RestController
public class UsersController {

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
        return ResponseEntity.ok(userResponse);
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
                    message = "Body content with all information about user",
                    response = UserDTOResponse.class),
            @ApiResponse(code = 400,
                    message = "Describes errors on invalid payload received, e.g: missing fields, invalid data form")
    })
    public ResponseEntity<UserDTOResponse> createUser(
            @ApiParam(value = "data of user", required = true)
            @Valid @RequestBody UserCreateDTORequest request
    ) {
        UserDTOResponse userResponse = usersService.createUser(request);
        return new ResponseEntity<>(userResponse, HttpStatus.CREATED);
    }

    // Update
    @PatchMapping(
            value = "/user/{id}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(
            value = "Update user",
            httpMethod = "PATCH",
            response = UserDTOResponse.class
    )
    @ApiResponses(value = {
            @ApiResponse(code = 201,
                    message = "Body content with all information about user",
                    response = UserDTOResponse.class),
            @ApiResponse(code = 400,
                    message = "Describes errors on invalid payload received, e.g: missing fields, invalid data form")
    })
    public ResponseEntity<UserDTOResponse> updateUser(
    		@RequestBody UserUpdateDTORequest user,
            @PathVariable("id") Long id
    ) throws BadRequestException {
        UserDTOResponse userResponse = usersService.updateUser(user, id);
        return ResponseEntity.ok(userResponse);
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
    
    // Search by name
    @GetMapping("/users/{name}")
    @ApiOperation(
            value = "Search user by name",
            httpMethod = "GET",
            response = UserDTOResponse[].class
    )
    @ApiResponses(value = {
            @ApiResponse(code = 201,
                    message = "Body content with all information about user",
                    response = UserDTOResponse[].class),
            @ApiResponse(code = 400,
                    message = "Describes errors on invalid payload received, e.g: missing fields, invalid data form")
    })
    public ResponseEntity<?> searchByName(@PathVariable("name") String name)
    {
        List<UserDTOResponse> userResponse = usersService.searchByName(name);
        return ResponseEntity.ok(userResponse);
    }
}
