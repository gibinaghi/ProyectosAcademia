package com.ayi.curso.rest.serv.ayispringrestful.controller;

import com.ayi.curso.rest.serv.ayispringrestful.exceptions.BadRequestException;
import com.ayi.curso.rest.serv.ayispringrestful.exceptions.InternalException;
import com.ayi.curso.rest.serv.ayispringrestful.exceptions.NotFoundException;
import com.ayi.curso.rest.serv.ayispringrestful.service.ReturnService;
import io.swagger.annotations.*;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(value = "Return Api", tags = {"Return Service"})
@RequestMapping(value = "/api", produces = {MediaType.APPLICATION_JSON_VALUE})
@AllArgsConstructor
@RestController
public class ReturnsController {

    private ReturnService returnService;

    // Delete lending
    @DeleteMapping("/return/{id}")
    @ApiOperation(
            value = "Delete a lending by id",
            httpMethod = "DELETE"
    )
    @ApiResponses(value = {
            @ApiResponse(code = 204, message = "Success. Lending deleted by id"),
            @ApiResponse(code = 404, message = "Lending not found"),
            @ApiResponse(code = 400 , message = "Bad request/Invalid field")})
    public ResponseEntity<Void> deleteLending(
            @ApiParam(name = "id", required = true, value = "Lending Id", example = "1")
            @PathVariable Long id
    ) throws BadRequestException, NotFoundException, InternalException {
        returnService.deleteLendingById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
