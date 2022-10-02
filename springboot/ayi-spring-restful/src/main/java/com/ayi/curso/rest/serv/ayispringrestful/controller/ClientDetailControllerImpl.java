package com.ayi.curso.rest.serv.ayispringrestful.controller;

import com.ayi.curso.rest.serv.ayispringrestful.dto.response.AddressResponse;
import com.ayi.curso.rest.serv.ayispringrestful.dto.response.ClientDetailResponse;
import com.ayi.curso.rest.serv.ayispringrestful.exceptions.ReadAccessException;
import com.ayi.curso.rest.serv.ayispringrestful.service.IClientDetailService;
import io.swagger.annotations.*;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@AllArgsConstructor
@RestController
@Api(value = "Client detail Api", tags = {"Client detail Service"})
@RequestMapping(value = "/client-detail", produces = {MediaType.APPLICATION_JSON_VALUE})
public class ClientDetailControllerImpl {
    private IClientDetailService clientDetailService;

    //Get all

    //Get by id
    @GetMapping(value = "/clientDetailById/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    @ApiOperation(
            value = "Retrieves data associated to Master List by Id",
            httpMethod = "GET",
            response = ClientDetailResponse.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200,message = "Success. Client detail found by ID."),
            @ApiResponse(code = 404, message = "Client detail not found"),
            @ApiResponse(code = 400 , message = "Bad request/Invalid field")})
    public ResponseEntity<?> findClientDetailById(
            @ApiParam(name = "id", required = true, value = "Client detail Id", example = "1")
            @PathVariable("id") Long id){

        Map<String, Object> response = new HashMap<>();

        try {
            return ResponseEntity.ok(clientDetailService.findClientDetailById(id));
        } catch (ReadAccessException e) {
            response.put("Código de error", 404);
            response.put("Mensaje", e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }catch (Exception ex) {
            response.put("Código de error", 400);
            response.put("Mensaje", ex.getMessage());
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }

    //Create

    //Update

    //Delete
    @DeleteMapping("/{id}")
    @ApiOperation(
            value = "Delete a client detail by id",
            httpMethod = "DELETE"
    )
    @ApiResponses(value = {
            @ApiResponse(code = 204, message = "Success. Client detail deleted by id"),
            @ApiResponse(code = 404, message = "Client detail not found"),
            @ApiResponse(code = 400 , message = "Bad request/Invalid field")})
    public ResponseEntity<Void> deleteClientDetail(
            @ApiParam(name = "id", required = true, value = "Client detail Id", example = "1")
            @PathVariable Long id
    ){
        clientDetailService.deleteClientDetail(id);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
